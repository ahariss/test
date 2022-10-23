package com.ahariss.test.mvvm.data.repository

import com.ahariss.test.mvvm.data.network.SafeApiCall
import com.ahariss.test.mvvm.data.network.service.APIService
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: APIService,
) : SafeApiCall {

    suspend fun getCharacters(offset: Int?) = safeApiCall {
        api.getCharacters(offset)
    }
}