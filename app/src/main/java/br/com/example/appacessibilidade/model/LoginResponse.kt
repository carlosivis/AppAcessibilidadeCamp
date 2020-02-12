package br.com.example.appacessibilidade.model

import java.io.Serializable

data class LoginResponse(
    val usuario: String,
    val senha: String

):Serializable

