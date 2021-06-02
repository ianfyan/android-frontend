package com.fs.bansosapp.data.repository

import androidx.lifecycle.LiveData
import com.fs.bansosapp.data.model.*
import com.fs.bansosapp.data.model.Response.ProfilResponse

interface BansosDataSource {
    fun getAllRecipient(token: String): LiveData<List<ReceipientsItem>>

    fun getAllBansos(token: String): LiveData<List<BansosItem>>

    fun getAllLocations(token: String): LiveData<List<LocationsItem>>

    fun getAllTransaction(token: String): LiveData<List<TransactionsItem>>

    fun getAllStatistic(token: String): LiveData<StatisticResponse>

    fun getProfil(token: String): LiveData<ProfilResponse>

    fun getToken(task: Task): LiveData<String>

}