package com.fs.bansosapp.data.repository

import android.util.Log
import com.fs.bansosapp.data.model.*
import com.fs.bansosapp.data.model.Response.ProfilResponse
import com.fs.bansosapp.retrofit.ApiConfig
import com.fs.bansosapp.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    private val api = ApiConfig

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service).apply { instance = this }
            }
    }

    fun getRecipient(token: String, callback: LoadRecipientCallback) {
        api.getApiService().getRecipient(token).enqueue(object : Callback<RecipientResponse> {
            override fun onResponse(
                call: Call<RecipientResponse>,
                response: Response<RecipientResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.receipients.apply {
                        this?.let { callback.onAllRecipientReceived(it) }
                        Log.e("getRecipient", response.body().toString())
                    }
                } else {
                    Log.e("getRecipient", "responseFail: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<RecipientResponse>, t: Throwable) {
                Log.e("getRecipient", "onFailure: ${t.message.toString()}")
            }

        })
    }

    fun getBansos(token: String, callback: LoadBansosCallback) {
        api.getApiService().getBansos(token).enqueue(object : Callback<BansosResponse> {
            override fun onResponse(
                call: Call<BansosResponse>,
                response: Response<BansosResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.bansos.apply {
                        this?.let { callback.onAllBansosReceived(it) }
                    }
                } else {
                    Log.e("getBansos", "responseFail: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<BansosResponse>, t: Throwable) {
                Log.e("getBansos", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getLocation(token: String, callback: LoadLocationCallBack) {
        api.getApiService().getLocation(token).enqueue(object : Callback<LocationResponse> {
            override fun onResponse(
                call: Call<LocationResponse>,
                response: Response<LocationResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.locations.apply {
                        this?.let { callback.onAllLocationReceived(it) }
                    }
                } else {
                    Log.e("getLocation", "responseFail: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LocationResponse>, t: Throwable) {
                Log.e("getLocation", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getTransaction(token: String, callback: LoadTransactionCallback) {
        api.getApiService().getTransaction(token).enqueue(object : Callback<TransactionResponse> {
            override fun onResponse(
                call: Call<TransactionResponse>,
                response: Response<TransactionResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.transactions.apply {
                        this?.let { callback.onAllTransactionReceived(it) }
                    }
                } else {
                    Log.e("getTransaction", "responseFail: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TransactionResponse>, t: Throwable) {
                Log.e("getTransaction", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getStatistic(token: String, callback: LoadStatisticCallback) {
        api.getApiService().getStatistic(token).enqueue(object : Callback<StatisticResponse> {
            override fun onResponse(
                call: Call<StatisticResponse>,
                response: Response<StatisticResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.apply {
                        this?.let { callback.onAllStatisticReceived(it) }
                    }
                } else {
                    Log.e("getStatistic", "responseFail: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<StatisticResponse>, t: Throwable) {
                Log.e("getStatistic", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getProfil(token: String, callback: LoadProfilCallback) {
        api.getApiService().getProfil(token).enqueue(object: Callback<ProfilResponse>{
            override fun onResponse(
                call: Call<ProfilResponse>,
                response: Response<ProfilResponse>
            ) {
                if (response.isSuccessful){
                    response.body()?.apply {
                        this?.let { callback.onAllProfilReceived(it) }
                    }
                }else {
                    Log.e("getProfil", "responseFail: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<ProfilResponse>, t: Throwable) {
                Log.e("getProfil", "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getToken(task: Task, callback: LoadTokenCallback) {
        api.getAuthApiService().getToken(task).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    response.body()?.apply {
                        this?.let { callback.onAllTokenReceived(it) }
                    }
                } else {
                    Log.e("getToken", "responseFail: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("getToken", "onFailure: ${t.message.toString()}")
            }
        })
    }

    interface LoadRecipientCallback {
        fun onAllRecipientReceived(recipientResponse: List<ReceipientsItem>)
    }

    interface LoadBansosCallback {
        fun onAllBansosReceived(bansosResponse: List<BansosItem>)
    }

    interface LoadLocationCallBack {
        fun onAllLocationReceived(locationResponse: List<LocationsItem>)
    }

    interface LoadTransactionCallback {
        fun onAllTransactionReceived(transactionResponse: List<TransactionsItem>)
    }

    interface LoadStatisticCallback {
        fun onAllStatisticReceived(statisticResponse: StatisticResponse)
    }

    interface LoadProfilCallback {
        fun onAllProfilReceived(profilResponse: ProfilResponse)
    }

    interface LoadTokenCallback {
        fun onAllTokenReceived(token: String)
    }
}