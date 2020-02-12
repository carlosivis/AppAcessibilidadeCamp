package br.com.example.appacessibilidade.model

import java.io.Serializable

data class LoginRequest(
    val usuario: String,
    val senha: String

):Serializable

