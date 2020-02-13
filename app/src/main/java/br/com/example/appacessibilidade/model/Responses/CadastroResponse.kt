package br.com.example.appacessibilidade.model.Responses

import br.com.example.appacessibilidade.model.Usuario.Endereco
import br.com.example.appacessibilidade.model.Usuario.Usuario
import br.com.example.appacessibilidade.model.Usuario.UsuarioPcd

data class CadastroResponse(
    val endereco: Endereco,
    val usuario: Usuario,
    val usuario_pcd: UsuarioPcd
)