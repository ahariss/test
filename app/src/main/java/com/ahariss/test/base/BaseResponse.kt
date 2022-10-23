package com.ahariss.test.base

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("code")
    val code: Int = -1

    @SerializedName("status")
    val status: String =""
}
