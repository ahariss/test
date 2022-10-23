package com.ahariss.test.mvvm.models

import com.google.gson.annotations.SerializedName

data class CharactersData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results")
    val characters: List<MarvelCharacter>,
    val total: Int
)