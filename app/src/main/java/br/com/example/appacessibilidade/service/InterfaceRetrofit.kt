package br.com.example.appacessibilidade

import br.com.example.appacessibilidade.model.LoginResponse
import br.com.example.appacessibilidade.model.Vaga
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface InterfaceRetrofit {

    @POST("usuario/{usuario}")
    fun login(@Path("usuario")login: String): Call<LoginResponse>

    @GET("vagas/json")
    fun vagas(): Call<Vaga>
}