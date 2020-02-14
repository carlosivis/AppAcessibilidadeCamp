package br.com.example.appacessibilidade.model.Usuario

data class User(
    val createdAt: String,
    val email: String,
    val id: Int,
    val id_tipo_usuario: Int,
    val nome: String,
    val updatedAt: String,
    val usuario: String
)