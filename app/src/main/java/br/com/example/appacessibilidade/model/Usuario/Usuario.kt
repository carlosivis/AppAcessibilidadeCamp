package br.com.example.appacessibilidade.model.Usuario

data class Usuario(

    val nome: String,
    val usuario: String,
    val email: String,
    val senha: String,
    val id_tipo_usuario: Int
)