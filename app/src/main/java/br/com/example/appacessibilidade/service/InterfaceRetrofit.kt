package br.com.example.appacessibilidade

import br.com.example.appacessibilidade.model.Requests.CadastroRequest
import br.com.example.appacessibilidade.model.Requests.CepRequest
import br.com.example.appacessibilidade.model.Requests.EsqueciSenhaRequest
import br.com.example.appacessibilidade.model.Requests.LoginRequest
import br.com.example.appacessibilidade.model.Responses.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface InterfaceRetrofit {

    @POST("/sessions")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/vagas")
    fun vagas(): Call<VagaResponse>

    @POST("/esqueciSenha")
    fun esqueciSenha(@Body esqueciSenhaRequest: EsqueciSenhaRequest): Call<EsqueciSenhaResponse>

    @POST("/pcd")
    fun cadastro(@Body cadastroRequest: CadastroRequest):Call<CadastroResponse>




    @GET("{cep}/json")
    fun consultCep(@Body cepRequest: CepRequest): Call<CepResponse>
}