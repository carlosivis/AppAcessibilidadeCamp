package br.com.example.projetoapi.service

import br.com.example.projetoapi.model.CepResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface InterfaceRetrofit {

    @GET("{cep}/json")
    fun consultCep(@Path("cep")cep: String): Call<CepResponse>
}