package com.dica.rickmorty.model.service

import com.dica.rickmorty.model.models.CharacterResponse
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacter(): List<CharacterResponse>?
}