package br.com.example.appacessibilidade.service

import br.com.example.appacessibilidade.InterfaceRetrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceCEP {
    private val BASE_URL = "https://viacep.com.br/ws/"
    val retrofit: InterfaceRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(InterfaceRetrofit::class.java)
    }

    private val okHttpClient: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }}