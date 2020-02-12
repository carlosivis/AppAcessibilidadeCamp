package br.com.example.appacessibilidade

import br.com.example.appacessibilidade.model.LoginResponse
import br.com.example.appacessibilidade.model.Vaga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface InterfaceRetrofit {

    @POST("{usuario,senha}/usuario")
    fun login(@Path("usuario , senha") login: String, senha: String): Call<LoginResponse>

    @GET("{vagas}/vagas")
    fun vagas(): Call<Vaga>


}