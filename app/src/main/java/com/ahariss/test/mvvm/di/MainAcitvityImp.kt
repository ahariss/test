package com.ahariss.test.mvvm.di

import com.ahariss.test.mvvm.models.MarvelCharacter
import javax.inject.Inject

class MainAcitvityImp @Inject constructor(
    val callback: Callback?
) {
    fun openCharacterDetails(marvelCharacter: MarvelCharacter) {
        callback?.openCharacterDetails(marvelCharacter)
    }

    interface Callback {
        fun openCharacterDetails(marvelCharacter: MarvelCharacter)

    }
}

