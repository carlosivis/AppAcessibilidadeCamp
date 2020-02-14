package br.com.example.appacessibilidade.model.Responses

import java.io.Serializable

data class CepResponse(
    val bairro: String,
    val cep: String,
    val complemento: String,
    val gia: String,
    val ibge: String,
    val localidade: String,
    val logradouro: String,
    val uf: String,
    val unidade: String
): Serializable