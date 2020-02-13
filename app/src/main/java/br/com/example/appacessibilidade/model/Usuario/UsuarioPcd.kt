package br.com.example.appacessibilidade.model.Usuario

data class UsuarioPcd(
    val dt_nascimento: String,
    val id_tipo_deficiencia: Int,
    val laudo_url: String,
    val rg: String,
    val telefone_celular: String,
    val telefone_fixo: String
)