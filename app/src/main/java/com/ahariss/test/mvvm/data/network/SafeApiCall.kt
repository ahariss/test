package com.ahariss.test.mvvm.data.network

import com.ahariss.test.base.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiCall.invoke()
                when (response) {
                    is BaseResponse -> {
                        if (response.code == 200) {
                            Resource.Success(response)
                        } else {
                            Resource.Failure(false, response.code, response.status)
                        }
                    }
                    else -> {
                        Resource.Success(response)
                    }
                }

            } catch (throwable: Throwable) {
                when (throwable) {

                    is HttpException -> {
                        Resource.Failure(
                            true,
                            throwable.code(),
                            throwable.response()?.errorBody().toString()
                        )
                    }
                    is IOException -> {
                        Resource.Failure(false, null, null)

                    }
                    else -> {
                        Resource.Failure(false, null, null)
                    }
                }
            }
        }
    }
}