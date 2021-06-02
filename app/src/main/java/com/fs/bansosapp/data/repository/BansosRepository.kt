package com.fs.bansosapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fs.bansosapp.data.model.*
import com.fs.bansosapp.data.model.Response.ProfilResponse

class BansosRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    BansosDataSource {

    companion object {
        @Volatile
        private var instance: BansosRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): BansosRepository =
            instance ?: synchronized(this) {
                instance ?: BansosRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllRecipient(token: String): LiveData<List<ReceipientsItem>> {
        val recipientResult = MutableLiveData<List<ReceipientsItem>>()
        remoteDataSource.getRecipient(token, object : RemoteDataSource.LoadRecipientCallback {
            override fun onAllRecipientReceived(recipientResponse: List<ReceipientsItem>) {
                recipientResult.postValue(recipientResponse)
            }
        })
        return recipientResult
    }

    override fun getAllBansos(token: String): LiveData<List<BansosItem>> {
        val bansosResult = MutableLiveData<List<BansosItem>>()
        remoteDataSource.getBansos(token, object : RemoteDataSource.LoadBansosCallback {
            override fun onAllBansosReceived(bansosResponse: List<BansosItem>) {
                bansosResult.postValue(bansosResponse)
            }
        })
        return bansosResult
    }

    override fun getAllLocations(token: String): LiveData<List<LocationsItem>> {
        val locationResult = MutableLiveData<List<LocationsItem>>()
        remoteDataSource.getLocation(token, object : RemoteDataSource.LoadLocationCallBack {
            override fun onAllLocationReceived(locationResponse: List<LocationsItem>) {
                locationResult.postValue(locationResponse)
            }
        })
        return locationResult
    }

    override fun getAllTransaction(token: String): LiveData<List<TransactionsItem>> {
        val transactionResult = MutableLiveData<List<TransactionsItem>>()
        remoteDataSource.getTransaction(token, object : RemoteDataSource.LoadTransactionCallback {
            override fun onAllTransactionReceived(transactionResponse: List<TransactionsItem>) {
                transactionResult.postValue(transactionResponse)
            }
        })
        return transactionResult
    }

    override fun getAllStatistic(token: String): LiveData<StatisticResponse> {
        val statisticResult = MutableLiveData<StatisticResponse>()
        remoteDataSource.getStatistic(token, object : RemoteDataSource.LoadStatisticCallback {
            override fun onAllStatisticReceived(statisticResponse: StatisticResponse) {
                statisticResult.postValue(statisticResponse)
            }
        })
        return statisticResult
    }

    override fun getProfil(token: String): LiveData<ProfilResponse> {
        val profilResult = MutableLiveData<ProfilResponse>()
        remoteDataSource.getProfil(token, object: RemoteDataSource.LoadProfilCallback{
            override fun onAllProfilReceived(profilResponse: ProfilResponse) {
                profilResult.postValue(profilResponse)
            }
        })
        return profilResult
    }

    override fun getToken(task: Task): LiveData<String> {
        val tokenResult = MutableLiveData<String>()
        remoteDataSource.getToken(task, object : RemoteDataSource.LoadTokenCallback {
            override fun onAllTokenReceived(token: String) {
                tokenResult.postValue(token)
            }
        })
        return tokenResult
    }
}