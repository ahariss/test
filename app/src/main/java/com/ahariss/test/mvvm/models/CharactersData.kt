package com.ahariss.test.mvvm.models

data class CharactersData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val characters: List<MarvelCharacter>,
    val total: Int
)