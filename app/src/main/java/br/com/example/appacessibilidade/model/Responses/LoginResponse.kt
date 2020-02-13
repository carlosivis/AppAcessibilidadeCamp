package br.com.example.appacessibilidade.model.Responses

import java.io.Serializable

data class LoginResponse(
    val usuario: String,
    val senha: String

):Serializable

