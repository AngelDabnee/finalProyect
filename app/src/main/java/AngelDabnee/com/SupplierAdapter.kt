package AngelDabnee.com

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SupplierAdapter(private val supplier:List<SupplierData>):RecyclerView.Adapter<SupplierAdapter.SupplierDataViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SupplierAdapter.SupplierDataViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return SupplierAdapter.SupplierDataViewHolder(inflador.inflate(R.layout.item_supplier, parent, false))
    }

    override fun onBindViewHolder(holder: SupplierAdapter.SupplierDataViewHolder, position: Int) {
        holder.render(supplier[position])
    }

    override fun getItemCount(): Int {
        return supplier.size
    }

    class SupplierDataViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name : TextView = itemView.findViewById(R.id.nameSupplierItem)
        val phone : TextView = itemView.findViewById(R.id.phoneSupplier)
        val email : TextView = itemView.findViewById(R.id.emailSupplier)
        val image : ImageView = itemView.findViewById(R.id.imageSupplier)

        fun render(supplerData : SupplierData){
            val context : Context = itemView.context
            name.text = supplerData.name
            phone.text = supplerData.phone
            email.text = supplerData.email
            Picasso.get().load(supplerData.image).into(image)
        }
    }
}