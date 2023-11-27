package AngelDabnee.com

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ExitFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exit, container, false)

        val btnSalir = view.findViewById<Button>(R.id.closeApp)
        btnSalir.setOnClickListener {
            activity?.finish()
            System.exit(0)
        }
        return view
    }
}