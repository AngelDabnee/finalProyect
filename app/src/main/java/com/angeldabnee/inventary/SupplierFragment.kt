package com.angeldabnee.inventary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SupplierFragment : Fragment() {
    private var suppliers:List<SupplierData> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_supplier, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.supplierRecycle)

        var bsd_new_id : Int =0
        var bsd_new_name:String
        var bsd_new_phone:String
        var bsd_new_email:String
        var bsd_new_image:String

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new_supplier)

        fab.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_supplier,null)
            bottomSheetDialog.setContentView(parentView)
            bottomSheetDialog.show()

            val newId = parentView.findViewById<EditText>(R.id.bsd_supplier_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_supplier_name)
            val newPhone = parentView.findViewById<EditText>(R.id.bsd_supplier_phone)
            val newEmail = parentView.findViewById<EditText>(R.id.bsd_supplier_email)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_supplier_image)

            val btnSubmitSupplier = parentView.findViewById<Button>(R.id.bsd_supplier_submit)

            btnSubmitSupplier.setOnClickListener{
                bsd_new_id = newId.text.toString().toInt()
                bsd_new_name = newName.text.toString()
                bsd_new_phone = newPhone.text.toString()
                bsd_new_email = newEmail.text.toString()
                bsd_new_image = newImage.text.toString()
                val toastMessage = "$bsd_new_id $bsd_new_name $bsd_new_phone $bsd_new_email $bsd_new_image"
                val newSupplierAdd = SupplierData(bsd_new_id,bsd_new_name,bsd_new_phone,bsd_new_email,bsd_new_image)
                suppliers.toMutableList().add(newSupplierAdd)
                recyclerView.adapter?.notifyDataSetChanged()

                Toast.makeText(context,toastMessage, Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()

            }
        }


        initData()
        var layoutManager = LinearLayoutManager(container?.context)
        var adapter = SupplierAdapter(suppliers)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter


        return view

    }
    fun initData(){
        suppliers = listOf(
            SupplierData(1,"Apple","11223311","apple@gmail.com","https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?202308111139"),
            SupplierData(2,"Microsoft","6699887744","micro@gmail.com","https://i.blogs.es/ed750c/microsoft-ai/500_333.jpeg"),
            SupplierData(3,"Sony","6655887744","sony@gmail.com","https://img.lalr.co/cms/2020/03/25163003/sonyal.jpg?size=sm")
        )
    }
}