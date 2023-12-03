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


class UserFragment : Fragment() {
    private var users:MutableList<UserData> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        var recyclerView = view.findViewById<RecyclerView>(R.id.usersRecycle)

        var bsd_new_id : Int =0
        var bsd_new_name:String
        var bsd_new_phone:String
        var bsd_new_email:String
        var bsd_new_password:String
        var bsd_new_image:String

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new_user)
        fab.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_user,null)
            bottomSheetDialog.setContentView(parentView)
            bottomSheetDialog.show()

            val newId = parentView.findViewById<EditText>(R.id.bsd_user_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_user_name)
            val newPhone = parentView.findViewById<EditText>(R.id.bsd_user_phone)
            val newEmail = parentView.findViewById<EditText>(R.id.bsd_user_email)
            val newPassword = parentView.findViewById<EditText>(R.id.bsd_user_password)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_user_image)

            val btnSubmitUser = parentView.findViewById<Button>(R.id.bsd_user_submit)
            btnSubmitUser.setOnClickListener{
                bsd_new_id = newId.text.toString().toInt()
                bsd_new_name = newName.text.toString()
                bsd_new_phone = newPhone.text.toString()
                bsd_new_email = newEmail.text.toString()
                bsd_new_password = newPassword.text.toString()
                bsd_new_image = newImage.text.toString()
                val toastMessage = "$bsd_new_id $bsd_new_name $bsd_new_phone $bsd_new_email $bsd_new_password $bsd_new_image"
                val newUserAdd = UserData(bsd_new_id,bsd_new_name,bsd_new_phone,bsd_new_email,bsd_new_password,bsd_new_image)

                users.add(newUserAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                Toast.makeText(context,"Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

        }



        initData()
        var layoutManager = LinearLayoutManager(container?.context)
        var adapter = UserAdapter(users)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter


        return view
    }
    fun initData(){
        users = mutableListOf(
            UserData(1,"Angel Dabnee","6622557788","angeldabnee@gmail.com","AngelDabnee","https://drive.google.com/uc?export=view&id=1XdSNFuyGXm7YlKXyuUkOEkRePCIWmYO0"),
            UserData(2,"Glenda Morales","6655889977","glenda@gmail.com","GlendaMorales","https://i.etsystatic.com/41932313/r/il/cb3152/5272343156/il_fullxfull.5272343156_q52x.jpg"),
            UserData(3,"Luis Acuña","6699887744","acuña@gmail.com","Luis Acuña","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuPQ1XK3TdLJu4fBDqtGXdcioOo8hVk4jWOw&usqp=CAU")
        )
    }
}