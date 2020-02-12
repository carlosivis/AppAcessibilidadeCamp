package br.com.example.appacessibilidade.model

import java.io.Serializable

data class VagaResponse(
    val titulo: String,
    val descricao: String,
    val quantidade_vagas: Int,
    val id_usuario_empresa: Int
):Serializable