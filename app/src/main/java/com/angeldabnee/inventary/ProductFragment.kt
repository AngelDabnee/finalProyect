package com.angeldabnee.inventary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProductFragment : Fragment() {
    private var products: MutableList<ProductStock> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_product, container, false)
        var recyclerView = view.findViewById<RecyclerView>(R.id.productsRecycle)


        var bsd_new_id : Int =0
        var bsd_new_name:String
        var bsd_new_price:Double
        var bsd_new_quantity:Int
        var bsd_new_unit:String
        var bsd_new_image:String

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new_product)
        fab.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_product,null)
            bottomSheetDialog.setContentView(parentView)
            bottomSheetDialog.show()

            val newId = parentView.findViewById<EditText>(R.id.bsd_product_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_product_name)
            val newPrice = parentView.findViewById<EditText>(R.id.bsd_product_price)
            val newQuantity = parentView.findViewById<EditText>(R.id.bsd_product_quantity)
            val newUnit = parentView.findViewById<EditText>(R.id.bsd_product_unit)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_product_image)

            val btnSubmit = parentView.findViewById<Button>(R.id.bsd_product_submit)


            btnSubmit.setOnClickListener{
                bsd_new_id = newId.text.toString().toInt()
                bsd_new_name = newName.text.toString()
                bsd_new_price = newPrice.text.toString().toDouble()
                bsd_new_quantity = newQuantity.text.toString().toInt()
                bsd_new_unit = newUnit.text.toString()
                bsd_new_image = newImage.text.toString()
                val toastMessage = "$bsd_new_id $bsd_new_name $bsd_new_price $bsd_new_quantity $bsd_new_unit $bsd_new_image"
                val newProductAdd = ProductStock(bsd_new_id,bsd_new_name,bsd_new_price,bsd_new_quantity,bsd_new_unit,bsd_new_image)

                products.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                Toast.makeText(context,"PRODUCTO REGISTRADO EXITOSAMENTE",Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

        }
        initData()
        var gridLayoutManager = GridLayoutManager(container?.context,2)

        var adapter = ProductAdapter(products)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.adapter = adapter


        return view

    }
    fun initData() {
        products = mutableListOf(
            ProductStock(1,"IPhone 13",198.58,2,"Piezas","https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcShSPLyy0cedE9vXeS2cyZ53PKgFpcuIpcNZoW7g3heTnZWFQoJ7VYwvMVKq5B-UhFTjL1H5kdOmQxHaL8g-xSRuM-HsifKpyugK5cQtOnYp4RYWNnQ0tk8dvs&usqp=CAE"),
            ProductStock(2,"MacBook Air",5486.58,3,"Piezas","https://http2.mlstatic.com/D_NQ_NP_709500-MLM69984412976_062023-O.webp"),
            ProductStock(4,"Monitor Sony de 43 Pulgadas",10005.3,3,"Piezas","https://m.media-amazon.com/images/I/611ZgcbBKyL._AC_UF1000,1000_QL80_.jpg"),
            ProductStock(5,"Monitor Sony de 80 Pulgadas",19999.3,2,"Piezas","https://http2.mlstatic.com/D_NQ_NP_650967-MLM72512124042_102023-O.webp"),
            ProductStock(6,"Laptop Dell Inspiron 15.6 Pulgadas",1299.1,3,"Piezas","https://i5.walmartimages.com.mx/mg/gm/3pp/asr/0ba709f9-cf95-49c6-a20b-d5b4acf30ab1.255c2df475209c948ad45600e6fade1e.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
            ProductStock(7,"Xbox Series S",5368.98,6,"Piezas","https://i5.walmartimages.com.mx/mg/gm/1p/images/product-images/img_large/00088984265135-2l.jpg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
            ProductStock(8,"Xbox Series X",50045.65,9,"Piezas","https://i5.walmartimages.com.mx/mg/gm/1p/images/product-images/img_large/00088984265135-2l.jpg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
            ProductStock(9,"Control Xbox One Blanco",699.69,5,"Piezas","https://m.media-amazon.com/images/I/71WX6wVepIL._AC_UF1000,1000_QL80_.jpg"),
            ProductStock(10,"Diadema Xbox LVL50",599.69,5,"Piezas","https://resources.claroshop.com/imagenes-sanborns-ii/1200/708056064549.jpg"),
        )
    }
}