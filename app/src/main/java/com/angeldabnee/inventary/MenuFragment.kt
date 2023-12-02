package com.angeldabnee.inventary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val btnProduct = view.findViewById<ImageView>(R.id.imgProduct)
        val btnSuppler = view.findViewById<ImageView>(R.id.imgSuppliers)
        val btnUser = view.findViewById<ImageView>(R.id.imgUsers)
        val btnExit = view.findViewById<ImageView>(R.id.imgExit)

        btnProduct.setOnClickListener{
            val navController : NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_menuFragment_to_productFragment)
        }
        btnSuppler.setOnClickListener{
            val navController : NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_menuFragment_to_supplierFragment)
        }
        btnUser.setOnClickListener{
            val navController : NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_menuFragment_to_userFragment)
        }
        btnExit.setOnClickListener{
            activity?.finish()
        }

        return view
    }
}