package AngelDabnee.com

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

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener{
            val navController : NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_userFragment_to_menuFragment)
        }

        return view
    }
    fun initData(){
        users = listOf(
            UserData(1,"Angel Dabnee","6622557788","dabnee@gmail.com","https://scontent.fhmo1-2.fna.fbcdn.net/v/t39.30808-6/399722136_1417271112535651_8075701572657257127_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_ohc=Qkk5BT1BDsUAX_3fJdT&_nc_ht=scontent.fhmo1-2.fna&oh=00_AfAHyIa9V71fZ8JcnnCju547pMzOtSGBinpIzAxIaIBttw&oe=6568154F"),
            UserData(2,"Glenda Morales","6655889977","glenda@gmail.com","https://scontent.fhmo1-2.fna.fbcdn.net/v/t39.30808-1/349012138_152303231037038_8434918744964554763_n.jpg?stp=dst-jpg_p320x320&_nc_cat=106&ccb=1-7&_nc_sid=5f2048&_nc_ohc=UhN59n68m64AX8GE4aI&_nc_ht=scontent.fhmo1-2.fna&oh=00_AfCUsqsk8ikXMU82eZBkG1qRmfaQVgX6qH6y71mEO46_HQ&oe=6568B989"),
            UserData(3,"Luis Acuña","6699887744","acuña@gmail.com","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuPQ1XK3TdLJu4fBDqtGXdcioOo8hVk4jWOw&usqp=CAU")
        )
    }

}