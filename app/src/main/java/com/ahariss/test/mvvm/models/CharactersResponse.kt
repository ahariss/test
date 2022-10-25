package com.ahariss.test.mvvm.models

import com.ahariss.test.base.BaseResponse
import com.google.gson.annotations.SerializedName

class CharactersResponse : BaseResponse() {
    @SerializedName("data")
    var data: CharactersData? = null

}
