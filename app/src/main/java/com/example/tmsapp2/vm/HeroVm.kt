package com.example.tmsapp2.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmsapp2.arch.UiState
import com.example.tmsapp2.model.Hero
import com.example.tmsapp2.model.mapToHeroes
import com.example.tmsapp2.repository.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class HeroVm @Inject constructor(
    private val heroRepository: HeroRepository
): ViewModel() {

    private val _state = MutableLiveData<UiState>()
    val state: LiveData<UiState>
        get() = _state


    val heroLiveData = MutableLiveData<List<Hero>>()

    fun getHeroArray(page: Int) {
        viewModelScope.launch {
            try {
                _state.value = UiState.Loading
                val response = heroRepository.getHeroFact()
                val heroes = response.body()?.message?.mapToHeroes() ?: emptyList()
                _state.value = UiState.HeroLoaded(heroes)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Download error")
            }
        }
    }
}

//        override fun onCleared() {
//            super.onCleared()
//            heroRepository.cancel()
//        }




//    private val _state = MutableLiveData<UiState>()
//    val state: LiveData<UiState> = _state
//
//    fun getHeroArray(page: Int) {
//        viewModelScope.launch {
//            try {
//                val response = heroRepository.getHeroFact()
//                _state.value = response.message().
//            } catch (e: Exception) {
//                // Handle error
//            }
//        }
//    }




//fun loadHeroFacts() {
//    _state.value = UiState.Loading
//    viewModelScope.launch(Dispatchers.IO) {
//        val response = heroRepository.getHeroFact()
//        if (response.isSuccessful) {
//            val heroFacts = response.body<HeroFactResponse>() ?: emptyList()
//
//
//
//            val characterMap = heroFacts.associateBy<Int, HeroFactResponse>(
//                keySelector = { it.characterId },
//                valueTransform = { it })
//            val heroLoaded = UiState.HeroLoaded(characterMap.values.toList())
//            _state.postValue(heroLoaded)
//        } else {
//            _state.postValue(UiState.Error("Failed to load hero facts"))
//        }
//    }
//}