package com.fs.bansosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.fs.bansosapp.data.model.Task
import com.fs.bansosapp.data.repository.BansosRepository

class MainViewModel (private val bansosRepository: BansosRepository) : ViewModel() {

    fun getRecipient(token: String) = bansosRepository.getAllRecipient(token)

    fun getBansos(token: String) = bansosRepository.getAllBansos(token)

    fun getLocation(token: String) = bansosRepository.getAllLocations(token)

    fun getTransaction(token: String) = bansosRepository.getAllTransaction(token)

    fun getStatistic(token: String) = bansosRepository.getAllStatistic(token)

    fun getProfil(token: String) = bansosRepository.getProfil(token)

    fun getToken(task: Task) = bansosRepository.getToken(task)
}