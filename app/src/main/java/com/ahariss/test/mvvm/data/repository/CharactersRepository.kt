package com.ahariss.test.mvvm.data.repository

import com.ahariss.test.mvvm.data.database.MarvelDatabase
import com.ahariss.test.mvvm.data.network.Resource
import com.ahariss.test.mvvm.data.network.SafeApiCall
import com.ahariss.test.mvvm.data.network.service.APIService
import com.ahariss.test.mvvm.models.CharactersData
import com.ahariss.test.mvvm.models.CharactersResponse
import com.ahariss.test.mvvm.models.MarvelCharacter
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: APIService,
    private val database: MarvelDatabase
) : SafeApiCall {

    suspend fun getCharactersLocal() = safeApiCall {
        val res = CharactersResponse()


        val list: List<MarvelCharacter>? = database.getMarvelCharacterDao().getAllCharacters()
        list?.let {
            res.code = 200
            res.data = CharactersData(
                characters = it,
                count = it.size,
                limit = 0,
                offset = it.size,
                total = it.size + 1
            )
            //Resource.Success(res)

        }
        res
    }

    suspend fun getCharacters(offset: Int?) = safeApiCall {
        api.getCharacters(offset)
    }

    suspend fun saveCharacters(characters: List<MarvelCharacter>) = safeApiCall {
        database.getMarvelCharacterDao().insertUpdate(characters)
    }

}