package com.ahariss.test.mvvm.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Events(
    val available: Int?,
    val collectionURI: String?,
    val comics: List<Comic>?,
    val returned: Int?
) : Parcelable