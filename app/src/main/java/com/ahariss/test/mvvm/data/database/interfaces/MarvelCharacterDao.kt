package com.ahariss.test.mvvm.data.database.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahariss.test.mvvm.models.MarvelCharacter

@Dao
interface MarvelCharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdate(characters: List<MarvelCharacter>)

    @Query("Select * from marvelCharacter")
    fun getAllCharacters(): List<MarvelCharacter>?

}