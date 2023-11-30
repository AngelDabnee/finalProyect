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


class UserFragment : Fragment() {
    private var users:List<UserData> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        var recyclerView = view.findViewById<RecyclerView>(R.id.usersRecycle)
        initData()
        var layoutManager = LinearLayoutManager(container?.context)
        var adapter = UserAdapter(users)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter


        return view
    }
    fun initData(){
        users = listOf(
            UserData(1,"Angel Dabnee","6622557788","dabnee@gmail.com","AngelDabnee","https://w0.peakpx.com/wallpaper/438/947/HD-wallpaper-el-rey-spiderman-chido-clasico.jpg"),
            UserData(2,"Glenda Morales","6655889977","glenda@gmail.com","GlendaMorales","https://i.etsystatic.com/41932313/r/il/cb3152/5272343156/il_fullxfull.5272343156_q52x.jpg"),
            UserData(3,"Luis Acuña","6699887744","acuña@gmail.com","Luis Acuña","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuPQ1XK3TdLJu4fBDqtGXdcioOo8hVk4jWOw&usqp=CAU")
        )
    }
}