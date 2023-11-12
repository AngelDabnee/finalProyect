package AngelDabnee.com

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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val name = view.findViewById<EditText>(R.id.editTextName)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)
        val btn = view.findViewById<Button>(R.id.buttonStart)

        btn.setOnClickListener()
        {
            if(name.text.isNotEmpty() && password.text.isNotEmpty()){
                val navController:NavController = Navigation.findNavController(view)
                navController.navigate(R.id.action_loginFragment_to_menuFragment)

                val nameText = name.text.toString()
                val passText = password.text.toString()
                val message = "Bienvenido: $nameText, contraseña $passText"
                Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
            }
            else{
                val bottomSheetDialog = BottomSheetDialog(view.context)
                val parentView: View = layoutInflater.inflate(R.layout.bsd_validation_login,null)
                bottomSheetDialog.setContentView(parentView)
                bottomSheetDialog.show()
            }
        }
        return view
    }
}