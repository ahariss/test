package com.ahariss.test.mvvm.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Story(
    val name: String?,
    val resourceURI: String?,
    val type: String?
) : Parcelable