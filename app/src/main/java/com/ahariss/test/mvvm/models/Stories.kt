package com.ahariss.test.mvvm.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stories(
    val available: Int?,
    val collectionURI: String?,
    val items: List<Story>?,
    val returned: Int?
) : Parcelable