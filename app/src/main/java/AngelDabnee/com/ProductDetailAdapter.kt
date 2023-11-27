package AngelDabnee.com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductDetailAdapter(private var productsDetails:List<ProductStock>):
    RecyclerView.Adapter<ProductDetailAdapter.ProductStockViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductStockViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return ProductStockViewHolder(inflador.inflate(R.layout.item_productdetail,parent,false))

    }

    override fun getItemCount(): Int {
        return productsDetails.size
    }

    override fun onBindViewHolder(holder: ProductStockViewHolder, position: Int) {
        holder.render(productsDetails[position])
    }
    class ProductStockViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val price : TextView = itemView.findViewById(R.id.priceProductDetail)
        val quantity :TextView = itemView.findViewById(R.id.quantityProductDetail)
        val name2: TextView = itemView.findViewById(R.id.nameProductDetail)
        val unit : TextView = itemView.findViewById(R.id.unitiProductDetail)
        val image : ImageView = itemView.findViewById(R.id.imgProductDetail)


        fun render(productStock:ProductStock){
            val context: Context = itemView.context
            price.text = productStock.price.toString()
            quantity.text = productStock.quantity.toString()
            name2.text = productStock.name
            unit.text = productStock.unit
            Picasso.get().load(productStock.image).into(image)

        }
   }
}