package com.example.firebasecrud

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrud.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*



class MainActivity : AppCompatActivity(), UserAdapter.OnDeleteListener,
    UserAdapter.OnUpdateListener {
    lateinit var binding: ActivityMainBinding
    private var firebaseDatabase: FirebaseDatabase? = null
    private var databaseReference: DatabaseReference? = null
    private var usersArrayList = ArrayList<User>()
    private var adapter: UserAdapter? = null

    private lateinit var recyclerView: RecyclerView

    private var selectedId : String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase?.getReference("data")
        binding.btnSubmit.setOnClickListener {
            if (textValidation()) {
                val fname = binding.etFname.text.toString()
                val lname = binding.etLname.text.toString()
                val mobile = binding.etMobile.text.toString()
                val email = binding.etEmail.text.toString()

                databaseReference = FirebaseDatabase.getInstance().getReference("data")
                val user = User(firstName = fname, lastName = lname, mobile = mobile, email = email)
                databaseReference!!.child(getRandomString(5)).setValue(user).addOnSuccessListener {

                    binding.etFname.text.clear()
                    binding.etLname.text.clear()
                    binding.etEmail.text.clear()
                    binding.etMobile.text.clear()

                    Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show()

                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }

            }
        }

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        usersArrayList = arrayListOf()
        databaseReference = FirebaseDatabase.getInstance().getReference("data")
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        val user = dataSnapShot.getValue(User::class.java)
                        Log.d("${snapshot.childrenCount}", "$dataSnapShot")
                        if (!usersArrayList.contains(user)) {
                            usersArrayList.add(user!!)
                        }
                    }
                    recyclerView.adapter =
                        UserAdapter(usersArrayList, this@MainActivity, this@MainActivity)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getRandomString(length: Int):String{
        val allowedChar = ('A'..'Z')+('a'..'z')+('0'..'9')
        return (1..length)
            .map { allowedChar.random() }
            .joinToString ("")
    }
    private fun textValidation(): Boolean {
        val firstName = binding.etFname.text.toString().trim()
        val lastName = binding.etLname.text.toString().trim()
        val mobile = binding.etMobile.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()

        if (firstName.isEmpty()) {
            binding.etFname.error = "Please enter your First Name"
            return false
        } else if (lastName.isEmpty()) {
            binding.etLname.error = "Please enter your Last Name"
            return false
        } else if (mobile.isEmpty()) {
            binding.etMobile.error = "Please enter a valid Mobile number"
            return false
        } else if (email.isEmpty()) {
            binding.etEmail.error = "Please enter a valid Email address"
            return false
        }
        return true
    }

    private fun initRecyclerView() {

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(ArrayList<User>(), this, this)
        recyclerView.adapter = adapter


    }

    override fun onDelete(user: User) {
        openDeleteDialog(user)

    }

    override fun onUpdate(user: User) {
        openUpdateDialog(user)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun openUpdateDialog(user: User) {
        Toast.makeText(this, "update", Toast.LENGTH_SHORT).show()

        //different functions for bottom sheet

        var bottomSheet = BottomSheetDialog(this)
        bottomSheet.requestWindowFeature(Window.FEATURE_NO_TITLE)
        bottomSheet.setContentView(R.layout.bottom_sheet)
        bottomSheet.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        bottomSheet.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //declare edittexts of bottomsheet

        val etFname: EditText? = bottomSheet.findViewById(R.id.btm_fname)
        val etLname: EditText? = bottomSheet.findViewById(R.id.btm_lname)
        val etMobile: EditText? = bottomSheet.findViewById(R.id.btm_mobile)
        val etEmail: EditText? = bottomSheet.findViewById(R.id.btm_email)
        val btnCancel: Button? = bottomSheet.findViewById(R.id.btm_can)
        val btnEdit: Button? = bottomSheet.findViewById(R.id.btm_edt)

        //get value from user class and put it in bottomsheet

        val sFname = user.firstName.toString()
        val sLname = user.lastName.toString()
        val sMobile = user.mobile.toString()
        val sEmail = user.email.toString()
        selectedId = user.id


        // show value in bottomsheet

        etFname!!.setText(sFname)
        etLname!!.setText(sLname)
        etEmail!!.setText(sEmail)
        etMobile!!.setText(sMobile)
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        bottomSheet.show()

        btnEdit?.setOnClickListener {

            val fname = etFname.text.toString()
            val lname = etLname.text.toString()
            val mobile = etMobile.text.toString()
            val email = etEmail.text.toString()
            val user = User(firstName = fname, lastName = lname, mobile = mobile, email = email)

//            val editMap = mapOf(
//                "email" to email,
//                "firstName" to fname,
//                "lastName" to lname,
//                "mobile" to mobile
//            )
               // databaseReference = FirebaseDatabase.getInstance().getReference("data")
               // val user = User(firstName = fname, lastName = lname, mobile = mobile, email = email)
                databaseReference!!.child(getRandomString(5)).setValue(user).addOnSuccessListener {

                    binding.etFname.text.clear()
                    binding.etLname.text.clear()
                    binding.etEmail.text.clear()
                    binding.etMobile.text.clear()

                    Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show()

                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }


//            databaseReference?.child(selectedId.toString())?.setValue(editMap)
////            if (userId != null) {
////                databaseReference!!.child("data").child(userId).updateChildren(editMap)
////            }
//            Toast.makeText(this, userId.toString(), Toast.LENGTH_SHORT).show()
//
//            Log.d("000000", mobile)
           bottomSheet.dismiss()
        }
        btnCancel?.setOnClickListener {
            bottomSheet.dismiss()
        }

    }

    private fun openDeleteDialog(user: User) {


        Toast.makeText(this, "delete ", Toast.LENGTH_LONG).show()
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Delete Teacher")

        // Create an Textview for the user to enter the confirmaion for deleting teacher
        val inputTextViewName = TextView(this)
        inputTextViewName.setHint("Are you sure want to delete ${user.firstName}")

        alertDialogBuilder.setView(inputTextViewName)

        alertDialogBuilder.setPositiveButton("Delete") { dialog, _ ->
            val userId = FirebaseAuth.getInstance().currentUser?.uid
            if (userId != null) {
                databaseReference?.child("data")?.child(userId)!!.removeValue()
            }
            Toast.makeText(this, "delete done", Toast.LENGTH_SHORT).show()
        }
        alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}


