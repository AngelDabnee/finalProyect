package com.angeldabnee.inventary

import android.content.Intent
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
import com.google.android.material.bottomsheet.BottomSheetDialog


class LoginFragment : Fragment() {
    private var users: List<UserData> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        var name = view.findViewById<EditText>(R.id.editName)
        var password = view.findViewById<EditText>(R.id.editPassword)

        val btnLogin = view.findViewById<Button>(R.id.btnSubmit)
        btnLogin.setOnClickListener()
        {
            validUser()
            if(name.text.isNotEmpty() && password.text.isNotEmpty()){
                val email = name.text.toString()
                val pass = password.text.toString()

                if(checkUser(email,pass,users)){
                    Toast.makeText(context,"Bienvenido",Toast.LENGTH_SHORT).show()
                    val i = Intent(view.context,MainActivity::class.java)
                    startActivity(i)
                    activity?.finish()


                }else{
                    Toast.makeText(context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT).show()
                }
            }
            else{
                val bottomSheetDialog = BottomSheetDialog(view.context)
                val parentView: View = layoutInflater.inflate(R.layout.bds_validation_login,null)
                bottomSheetDialog.setContentView(parentView)
                bottomSheetDialog.show()
            }
        }
        return view
    }
    private fun checkUser(username:String,password:String,users:List<UserData>):Boolean{
        return users.any{users->username==users.email && password == users.password}
    }

    fun validUser(){
        users = listOf(
            UserData(1,"Angel Dabnee","6622557788","angeldabnee@gmail.com","AngelDabnee","https://w0.peakpx.com/wallpaper/438/947/HD-wallpaper-el-rey-spiderman-chido-clasico.jpg"),
            UserData(2,"Glenda Morales","6655889977","glenda@gmail.com","GlendaMorales","https://i.etsystatic.com/41932313/r/il/cb3152/5272343156/il_fullxfull.5272343156_q52x.jpg"),
            UserData(3,"Luis Acuña","6699887744","acuña@gmail.com","luisacuna","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuPQ1XK3TdLJu4fBDqtGXdcioOo8hVk4jWOw&usqp=CAU")
        )
    }
}