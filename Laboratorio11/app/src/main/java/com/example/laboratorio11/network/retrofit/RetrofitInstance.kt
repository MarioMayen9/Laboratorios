package com.example.laboratorio11.network.retrofit

import com.example.laboratorio11.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://retrofit.up.railway.app/"

object RetrofitInstance {

    private var TOKEN = ""



    fun setToken(token: String) {
        this.TOKEN = token
    }

    //retrofit instance builder
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}