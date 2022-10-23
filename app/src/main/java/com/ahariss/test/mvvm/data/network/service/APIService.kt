package com.ahariss.test.mvvm.data.network.service

import com.ahariss.sample.mvvm.models.CharactersResponse
import com.ahariss.test.config.Global.CHARACTERS_URL
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {


    @GET(CHARACTERS_URL)
    suspend fun getCharacters(
        @Query("offset") offset: Int?
    ): CharactersResponse


}