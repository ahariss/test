package com.ahariss.sample.mvvm.models

import com.ahariss.test.base.BaseResponse
import com.google.gson.annotations.SerializedName

class CharactersResponse : BaseResponse() {
    @SerializedName("data")
    val data: CharactersData? = null

}
