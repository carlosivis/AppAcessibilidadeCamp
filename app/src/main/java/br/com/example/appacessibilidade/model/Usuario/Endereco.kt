package br.com.example.appacessibilidade.model.Usuario

data class Endereco(
    val bairro: String,
    val cep: Int,
    val cidade: String,
    val complemento: String,
    val estado: String,
    val logradouro: String,
    val numero: Int,
    val pais: String
)