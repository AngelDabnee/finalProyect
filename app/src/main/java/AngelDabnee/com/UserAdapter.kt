package AngelDabnee.com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class UserAdapter(private val user:List<UserData>):RecyclerView.Adapter<UserAdapter.UserDataViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.UserDataViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return UserDataViewHolder(inflador.inflate(R.layout.item_user,parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapter.UserDataViewHolder, position: Int) {
        holder.render(user[position])
    }

    override fun getItemCount(): Int {
        return user.size

    }

    class UserDataViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name: TextView = itemView.findViewById(R.id.nameUser)
        val phone: TextView = itemView.findViewById(R.id.phoneUser)
        val email: TextView = itemView.findViewById(R.id.emailUser)
        val image : ImageView = itemView.findViewById(R.id.imgUser)

        fun render(userData: UserData){
            val context : Context = itemView.context
            name.text = userData.name
            phone.text = userData.phone
            email.text = userData.email
            Picasso.get().load(userData.image).into(image)
        }

    }

}