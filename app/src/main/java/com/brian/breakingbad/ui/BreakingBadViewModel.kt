package com.brian.breakingbad.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.breakingbad.network.BreakingBadAPi
import com.brian.breakingbad.network.Character
import kotlinx.coroutines.launch

class BreakingBadViewModel : ViewModel() {



    private val _character = MutableLiveData<Character>()
    val character : LiveData<Character> = _character



    fun getCharacter(): MutableLiveData<Character> {
        viewModelScope.launch {
            _character.value = BreakingBadAPi.retrofitService.getRandomCharacter()
//            try {
//                _character.value = BreakingBadAPi.retrofitService.getRandomCharacter()
//                Log.d("ViewModel", "element fetched")
//            }catch (e : java.lang.Exception){
//                Log.e("ViewModel", "Error fetching element")
//            }
        }
        return _character
    }
}