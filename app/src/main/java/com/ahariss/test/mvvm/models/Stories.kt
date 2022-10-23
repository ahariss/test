package com.ahariss.sample.mvvm.models

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Story>,
    val returned: Int
)