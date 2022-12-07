package com.example.mvvmcleanarchidemo1.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanarchidemo1.data.model.GamesAPIResponseMario
import com.example.mvvmcleanarchidemo1.data.util.Resource
import com.example.mvvmcleanarchidemo1.domain.usecase.GamesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val getGamesUsecase:GamesUsecase) :ViewModel() {

    val gamesdetails: MutableLiveData<Resource<GamesAPIResponseMario>> = MutableLiveData()

    fun getGamesData(){
        viewModelScope.launch(Dispatchers.IO) {
            gamesdetails.postValue(Resource.Loading())
            try {
                val apiRes=getGamesUsecase.execute()
                gamesdetails.postValue(apiRes)
            }
            catch (e:Exception){
                gamesdetails.postValue(Resource.Error(e.message.toString()))
            }

        }
    }
}