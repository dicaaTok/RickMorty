package com.dica.rickmorty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dica.rickmorty.model.models.CharacterResponse
import com.dica.rickmorty.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    private val  _character : MutableLiveData<CharacterResponse?>()
    val character : LiveData<CharacterResponse> = _character

    fun gatCharacter() {
        viewModelScope.launch {
            val response = repository.getCharacter()
                 Log.e("TEST","Sussess : ${response?.results?.size} characters loaded")
            Log.e("TEST","getCharacter: Rrsponse = $response")
            _character.value = response
        }  catch (e : Exception) {
            Log.e("TEST", "Error: ${e.localizedMessage}", e)
            Log.e("ololo", "getCharacter: Error = ${e.message}")
            e.printStackTrace()
        }
    }

}