package com.example.fireimage

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.fireimage.databinding.FragmentHomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.ByteArrayOutputStream


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var db: DatabaseReference
    var nodeId = ""
    var sImage: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nodeId = it.getString("itm_id").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnImg.setOnClickListener() {
            var i = Intent(Intent.ACTION_GET_CONTENT)
            i.setType("image/*")
            ActivityResultLauncher.launch(i)
        }

        binding.btnSubmit.setOnClickListener() {
            add_Data()
        }

        binding.btnView.setOnClickListener {

            val fragment = ListFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragment)
                .addToBackStack(HomeFragment().toString())
                .commit()
        }

        if (nodeId != "") {
            displayData()
        }

        binding.btnUpdate.setOnClickListener {
            update_data()
        }

        binding.btnDel.setOnClickListener {
            delete_data()
        }
        return root
    }

    private fun delete_data() {

        db = FirebaseDatabase.getInstance().getReference("items")
        db.child(nodeId).removeValue().addOnSuccessListener {

            binding.etName.text.clear()
            binding.etDes.text.clear()
            sImage = ""
            binding.imgView.setImageBitmap(null)
            Toast.makeText(context, "data deleted", Toast.LENGTH_SHORT).show()

            val fragment = ListFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragment)
                .addToBackStack(HomeFragment().toString())
                .commit()
        }.addOnFailureListener {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun update_data() {

        val itemName = binding.etName.text.toString()
        val itemDs = binding.etDes.text.toString()
        db = FirebaseDatabase.getInstance().getReference("items")
        val item = itemDs(itemName, itemDs, sImage)

        db.child(nodeId).setValue(item).addOnSuccessListener {
            binding.etName.text.clear()
            binding.etDes.text.clear()
            binding.imgView.setImageBitmap(null)
            sImage = ""
            binding.btnUpdate.visibility = View.INVISIBLE
            binding.btnDel.visibility = View.INVISIBLE
            binding.btnSubmit.visibility = View.VISIBLE
            Toast.makeText(context, "data updated", Toast.LENGTH_SHORT).show()

            val fragment = ListFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragment)
                .addToBackStack(HomeFragment().toString())
                .commit()

        }.addOnFailureListener {
            Toast.makeText(context, "data not inserted", Toast.LENGTH_SHORT).show()
        }

    }

    private fun displayData() {
        db = FirebaseDatabase.getInstance().getReference("items")
        db.child(nodeId).get().addOnSuccessListener {
            if (it.exists()) {

                binding.etName.setText(it.child("itemName").value.toString())
                binding.etDes.setText(it.child("itemDes").value.toString())
                sImage = it.child("itemImg").value.toString()
                val byte = Base64.decode(sImage, Base64.DEFAULT)
                val bitmap = BitmapFactory.decodeByteArray(byte, 0, byte.size)
                binding.imgView.setImageBitmap(bitmap)
                binding.btnUpdate.visibility = View.VISIBLE
                binding.btnDel.visibility = View.VISIBLE
                binding.btnSubmit.visibility = View.INVISIBLE


            }
        }

    }

    private fun add_Data() {
        val itemName = binding.etName.text.toString()
        val itemDes = binding.etDes.text.toString()
        db = FirebaseDatabase.getInstance().getReference("items")
        val item = itemDs(itemName, itemDes, sImage)
        val databaseReference = FirebaseDatabase.getInstance().reference
        val id = databaseReference.push().key
        db.child(id.toString()).setValue(item).addOnSuccessListener {

            binding.etName.text.clear()
            binding.etDes.text.clear()
            sImage = ""
            binding.imgView.setImageBitmap(null)
            Toast.makeText(context, "data added successfully", Toast.LENGTH_SHORT).show()


        }.addOnFailureListener {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private val ActivityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val uri = result.data!!.data
            try {
                val inputStream = context?.contentResolver?.openInputStream(uri!!)
                val myBitmap = BitmapFactory.decodeStream(inputStream)
                val stream = ByteArrayOutputStream()
                myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                val bytes = stream.toByteArray()
                sImage = Base64.encodeToString(bytes, Base64.DEFAULT)
                binding.imgView.setImageBitmap(myBitmap)
                inputStream!!.close()
                Toast.makeText(context, "image selected", Toast.LENGTH_SHORT).show()

            } catch (ex: Exception) {
                Toast.makeText(context, ex.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}