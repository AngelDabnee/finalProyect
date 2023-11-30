package com.angeldabnee.inventary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SupplierFragment : Fragment() {
    private var suppliers:List<SupplierData> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_supplier, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.supplierRecycle)
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