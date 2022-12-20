package com.example.gamessupermariofinal.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.GamesDomainMario
import com.example.domain.usecase.GamesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GameViewModel @Inject constructor(private val gamesUsecase: GamesUsecase) :ViewModel() {
    val gamesdetails: MutableLiveData<GamesDomainMario> = MutableLiveData()

    fun getGamesData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val apiRes = gamesUsecase.execute()
                gamesdetails.postValue(apiRes)
            } catch (e: Exception) {
                Log.d("MyTag",e.toString())
            }

        }

    }
}