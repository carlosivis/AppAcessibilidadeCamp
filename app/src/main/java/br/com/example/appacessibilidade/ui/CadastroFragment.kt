package br.com.example.appacessibilidade.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.example.appacessibilidade.R
import br.com.example.appacessibilidade.Service
import br.com.example.appacessibilidade.model.Requests.CadastroRequest
import br.com.example.appacessibilidade.model.Responses.CadastroResponse
import br.com.example.appacessibilidade.model.Usuario.Endereco
import br.com.example.appacessibilidade.model.Usuario.Usuario
import br.com.example.appacessibilidade.model.Usuario.UsuarioPcd
import kotlinx.android.synthetic.main.fragment_cadastro.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CadastroFragment : Fragment() , View.OnClickListener {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnConfirmarCadastro)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnConfirmarCadastro ->cadastro()
        }
    }


//    fun consultCEP(){
//        ServiceCEP.retrofit.consultCep(
//            cepRequest = CepRequest(
//                idCep.text.toString()
//        ))
//            .enqueue(object: Callback<CepResponse> {
//                override fun onFailure(call: Call<CepResponse>, t: Throwable) {
//                }
//
//                override fun onResponse(call: Call<CepResponse>, response: Response<CepResponse>) {
//                    Log.d("Sucesso",response.body().toString())
//                    response.body()?.let {endereço ->
////                        cadastroCidade.setText(endereço.localidade)
////                        cadastroLogradouro.setText(endereço.logradouro)
//                    }
//                }
//            })
//    }

    private fun cadastro(){
        Service.retrofit.cadastro(
            cadastroRequest = CadastroRequest(
                endereco = Endereco(
                    cadastroBairro.text.toString(),
                    idCep.text.toString().toInt(),
                    cadastroCidade.text.toString(),
                    "",
                    cadastroUF.text.toString(),
                    cadastroLogradouro.text.toString(),
                    0,
                    "Brasil"

                ),
                usuario = Usuario(
                cadastroNomeUsuario.text.toString(),
                cadastroUsuarioPersonName.text.toString(),
                cadastroEmailUsuario.text.toString(),
                cadastroSenha.text.toString(),
                id_tipo_usuario = 1
            ),
                usuario_pcd = UsuarioPcd(
                    cadastroNascimento.text.toString(),
                    2,
                    "",
                    cadastroRG.text.toString(),
                    cadastroCelular.text.toString(),
                    cadastroTelefone.text.toString()
                )
            )
        ).enqueue(object : Callback<CadastroResponse>{
            override fun onFailure(call: Call<CadastroResponse>, t: Throwable) {
                Log.ERROR.toString()
            }

            override fun onResponse(
                call: Call<CadastroResponse>,
                response: Response<CadastroResponse>
            ) {
                Log.d("Sucesso cadastro", response.body().toString())
                if(response.isSuccessful){
                    navController!!.navigate(R.id.action_cadastroFragment_to_feedFragment)
                }
                else
                    Log.d("Falha Cadastro", response.toString())

            }

        })
    }

}



