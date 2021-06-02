package com.fs.bansosapp.ui.viewmodel

import android.content.Context
import com.fs.bansosapp.data.repository.BansosRepository
import com.fs.bansosapp.data.repository.RemoteDataSource
import com.fs.bansosapp.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): BansosRepository {
        val apiService = ApiConfig.getApiService()
        val remoteDataSource = RemoteDataSource.getInstance(apiService)

        return BansosRepository.getInstance(remoteDataSource)
    }
}