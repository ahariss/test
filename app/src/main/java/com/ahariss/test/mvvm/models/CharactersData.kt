package com.ahariss.sample.mvvm.models

data class CharactersData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val characters: List<Character>,
    val total: Int
)