package br.com.example.appacessibilidade.model.Responses

import br.com.example.appacessibilidade.model.Usuario.User

data class CadastroResponse(
    val token: String,
    val usuario: User
)