package br.com.example.appacessibilidade.model.Requests

import java.io.Serializable

data class LoginRequest(
    val usuario: String,
    val senha: String

):Serializable

