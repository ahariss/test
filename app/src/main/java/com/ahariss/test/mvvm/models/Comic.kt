package com.ahariss.test.mvvm.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comic(
    val name: String?,
    val resourceURI: String?
) : Parcelable