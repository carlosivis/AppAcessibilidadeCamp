package br.com.example.appacessibilidade


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.example.appacessibilidade.model.Requests.CadastroRequest
import br.com.example.appacessibilidade.model.Usuario.Endereco
import br.com.example.appacessibilidade.model.Usuario.Usuario
import br.com.example.appacessibilidade.model.Usuario.UsuarioPcd
import kotlinx.android.synthetic.main.fragment_cadastro.*

/**
 * A simple [Fragment] subclass.
 */
class CadastroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }


    fun cadastro(){
        Service.retrofit.cadastro(
            cadastroRequest = CadastroRequest(
                endereco = Endereco(
                    "Castelo",
                    1,
                    "Belorihills",
                    "",
                    "MG",
                    "Rua",
                    2,
                    "Hu3br"

                ),
                usuario = Usuario(
                cadastroNomeUsuario.text.toString(),
                cadastroUsuarioPersonName.text.toString(),
                cadastroEmailUsuario.text.toString(),
                cadastroSenha.text.toString(),
                id_tipo_usuario = 1
            ),
                usuario_pcd = UsuarioPcd(
                    "1999"
                )
            )
        )
    }

}
