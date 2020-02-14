package br.com.example.appacessibilidade.model.Responses

import br.com.example.appacessibilidade.model.Usuario.User
import java.io.Serializable

data class LoginResponse(
    val token: String,
    val user: User
):Serializable