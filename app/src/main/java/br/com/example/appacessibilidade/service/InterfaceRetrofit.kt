package br.com.example.appacessibilidade

import br.com.example.appacessibilidade.model.LoginRequest
import br.com.example.appacessibilidade.model.LoginResponse
import br.com.example.appacessibilidade.model.VagaResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface InterfaceRetrofit {

    @POST("{usuario,senha}/usuario")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("{vagas}/vagas")
    fun vagas(): Call<VagaResponse>


}