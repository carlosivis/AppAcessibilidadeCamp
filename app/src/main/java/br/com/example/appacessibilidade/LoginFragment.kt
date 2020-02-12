package br.com.example.appacessibilidade


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.example.appacessibilidade.model.LoginRequest
import br.com.example.appacessibilidade.model.LoginResponse
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() , View.OnClickListener{

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnCadastro).setOnClickListener(this)
    }
    override fun onClick(v: View?) {
    when(v!!.id){
        R.id.btnLogin ->{
            login()
        }
        R.id.btnCadastro ->navController!!.navigate(R.id.action_loginFragment_to_cadastroFragment)
    }
    }

    fun login(){
        Service.retrofit.login(
            loginRequest = LoginRequest(
                txtLogin.text.toString(),
                txtPassword.text.toString()
                )
        ).enqueue(object :Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("Deu ruim",t.toString())
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    loginResponse: Response<LoginResponse>
                ) {
                    if(loginResponse.isSuccessful) {
                        Log.d("Sucesso", loginResponse.body().toString())
                        navController!!.navigate(R.id.action_loginFragment_to_feedFragment)
                    }
                  else {
                        Log.d("Falha", loginResponse.errorBody().toString())
                        txtFalhaLogin.text = "Usuario e/ou senha incorretos!!!"
                    }
                }
            })


    }

}

