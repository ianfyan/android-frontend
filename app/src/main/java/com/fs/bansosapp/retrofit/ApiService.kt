package com.fs.bansosapp.retrofit

import com.fs.bansosapp.data.model.*
import com.fs.bansosapp.data.model.Response.ProfilResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("list/receipient")
    fun getRecipient(@Header("Authorization") token: String): Call<RecipientResponse>

    @GET("list/bansos")
    fun getBansos(@Header("Authorization") token: String): Call<BansosResponse>

    @GET("list/location")
    fun getLocation(@Header("Authorization") token: String): Call<LocationResponse>

    @GET("list/transaction")
    fun getTransaction(@Header("Authorization") token: String): Call<TransactionResponse>

    @GET("info/stats")
    fun getStatistic(@Header("Authorization") token: String): Call<StatisticResponse>

    @GET("info/user")
    fun getProfil(@Header("Authorization") token: String): Call<ProfilResponse>


    @POST("userlogin")
    @Headers("Content-Type: application/json")
    fun getToken(@Body task: Task): Call<String>
}