package com.brian.breakingbad.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.breakingbad.network.BreakingBadAPi
import com.brian.breakingbad.network.Character
import com.brian.breakingbad.network.CharacterItem
import kotlinx.coroutines.launch

class BreakingBadViewModel : ViewModel() {



    private val _character = MutableLiveData<MutableList<CharacterItem>>()
    val character : LiveData<MutableList<CharacterItem>> get() = _character



    fun getCharacter(): MutableLiveData<MutableList<CharacterItem>>{
        viewModelScope.launch {

            try {
                _character.value = BreakingBadAPi.retrofitService.getRandomCharacter()
                Log.d("ViewModel", "element fetched")
            }catch (e: Exception){
                Log.e("ViewModel", "Error fetching element")
            }

        }
        return _character
    }
}