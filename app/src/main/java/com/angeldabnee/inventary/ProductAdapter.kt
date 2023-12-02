package com.angeldabnee.inventary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(private var products:List<ProductStock>):
    RecyclerView.Adapter<ProductAdapter.ProductStockViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductStockViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return ProductStockViewHolder(inflador.inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: ProductStockViewHolder, position: Int) {
        holder.render(products[position])
        val btnImage = holder.image
        btnImage.setOnClickListener{
            Toast.makeText(btnImage.context, "Aplastamos la Imagen", Toast.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ProductStockViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = itemView.findViewById(R.id.productName)
        val image : ImageView = itemView.findViewById(R.id.imgProduct)

        val price : TextView = itemView.findViewById(R.id.productPrice)
        val quantity :TextView = itemView.findViewById(R.id.productQuantity)
        val unit : TextView = itemView.findViewById(R.id.productUnit)


        fun render(productStock:ProductStock){
            val context: Context = itemView.context
            name.text = productStock.name
            price.text = productStock.price.toString()
            quantity.text = productStock.quantity.toString()
            unit.text = productStock.unit
            Picasso.get().load(productStock.image).into(image)

        }
    }

}