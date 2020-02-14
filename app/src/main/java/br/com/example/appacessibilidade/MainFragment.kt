package br.com.example.appacessibilidade


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.example.appacessibilidade.R


class MainFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_go_login).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_go_cadastro).setOnClickListener(this)
        view.findViewById<Button>(R.id.menuHome).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
    when(v!!.id){
        R.id.menuHome->navController!!.navigate(R.id.feedFragment)
        R.id.btn_go_login -> navController!!.navigate(
            R.id.action_mainFragment_to_loginFragment
        )
        R.id.btn_go_cadastro -> navController!!.navigate(
            R.id.action_mainFragment_to_cadastroFragment
        )
    }
    }
}
