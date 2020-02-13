package br.com.example.appacessibilidade

import br.com.example.appacessibilidade.model.Requests.CadastroRequest
import br.com.example.appacessibilidade.model.Requests.EsqueciSenhaRequest
import br.com.example.appacessibilidade.model.Requests.LoginRequest
import br.com.example.appacessibilidade.model.Responses.CadastroResponse
import br.com.example.appacessibilidade.model.Responses.EsqueciSenhaResponse
import br.com.example.appacessibilidade.model.Responses.LoginResponse
import br.com.example.appacessibilidade.model.Responses.VagaResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface InterfaceRetrofit {

    @POST("{usuario,senha}/usuario")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("{vagas}/vagas")
    fun vagas(): Call<VagaResponse>

    @POST("{usuario}/esqueciSenha")
    fun esqueciSenha(@Body esqueciSenhaRequest: EsqueciSenhaRequest): Call<EsqueciSenhaResponse>

    @POST("{cadastro}/pcd")
    fun cadastro(@Body cadastroRequest: CadastroRequest):Call<CadastroResponse>


}