package com.example.fireimage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fireimage.databinding.FragmentListBinding
import com.google.firebase.database.*

class ListFragment : Fragment() {

    private lateinit var db: DatabaseReference
    private lateinit var itemArrayList: ArrayList<itemDs>
    private lateinit var nodeList: ArrayList<tempData>
    private lateinit var binding: FragmentListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.recycler.layoutManager = GridLayoutManager(context, 3)
        binding.recycler.hasFixedSize()
        itemArrayList = arrayListOf<itemDs>()
        nodeList = arrayListOf<tempData>()
        getItemData()
        return binding.root
    }

    private fun getItemData() {
        db = FirebaseDatabase.getInstance().getReference("items")
        var query: Query
        query = db.orderByChild("itemName")
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var ky: String = ""
                    var itname: String = ""
                    for (itmsnapshot in snapshot.children) {
                        val item = itmsnapshot.getValue(itemDs::class.java)
                        itemArrayList.add(item!!)
                        ky = itmsnapshot.key.toString()
                        itname = item.itemName.toString()
                        val tmpitm = tempData(ky, itname)
                        nodeList.add(tmpitm)
                    }
                    var adapter = itemAdapter(itemArrayList)
                    binding.recycler.adapter = adapter
                    adapter.setonItemClickListener(object : itemAdapter.onItemClickListener {
                        override fun onItemClick(position: Int) {
                            val ctitm = nodeList[position]
                            val nodePath = ctitm.id.toString()
                            val fragment = HomeFragment()
                            val bundle = Bundle()
                            bundle.putString("itm_id", nodePath.toString())
                            fragment.arguments = bundle
                            val fragmentManager = activity?.supportFragmentManager
                            val fragmentTransaction = fragmentManager!!.beginTransaction()
                            fragmentTransaction.replace(com.example.fireimage.R.id.frame, fragment)
                                .commit()
                        }
                    })
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}