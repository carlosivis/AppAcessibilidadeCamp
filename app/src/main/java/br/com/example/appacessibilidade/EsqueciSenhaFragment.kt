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
import br.com.example.appacessibilidade.model.Requests.EsqueciSenhaRequest
import br.com.example.appacessibilidade.model.Responses.EsqueciSenhaResponse
import kotlinx.android.synthetic.main.fragment_esqueci_senha.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class EsqueciSenhaFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_esqueci_senha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnEnviarEsqueciSenha)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnEnviarEsqueciSenha ->{
                esqueciSenha()
                navController!!.navigate(R.id.action_esqueciSenhaFragment_to_loginFragment)
            }
        }
    }


    fun esqueciSenha(){
        Service.retrofit.esqueciSenha(
            esqueciSenhaRequest = EsqueciSenhaRequest(
                txtRecuperaSenha.text.toString()
            )
        ).enqueue(object :Callback<EsqueciSenhaResponse>{
            override fun onFailure(call: Call<EsqueciSenhaResponse>, t: Throwable) {
                Log.d("Erro", t.toString())
            }

            override fun onResponse(
                call: Call<EsqueciSenhaResponse>,
                response: Response<EsqueciSenhaResponse>
            ) {
                Log.d("Sucesso", response.body().toString())
                Log.d("${response.body()}", toString())

            }

        })
    }

}
