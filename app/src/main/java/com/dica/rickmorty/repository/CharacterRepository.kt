package com.dica.rickmorty.repository

import com.dica.rickmorty.model.core.RetrofitClient

class CharacterRepository {
    suspend fun getCharacter() = RetrofitClient.characterService.getCharacter()


}