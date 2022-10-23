package com.ahariss.test.mvvm.models

data class Events(
    val available: Int,
    val collectionURI: String,
    val comics: List<Comic>,
    val returned: Int
)