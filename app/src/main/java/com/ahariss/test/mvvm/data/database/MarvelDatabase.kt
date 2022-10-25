package com.ahariss.test.mvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahariss.test.mvvm.data.database.converters.*
import com.ahariss.test.mvvm.data.database.interfaces.MarvelCharacterDao
import com.ahariss.test.mvvm.models.MarvelCharacter

@Database(entities = arrayOf(MarvelCharacter::class), version = 1, exportSchema = false)
@TypeConverters(
    ThumbConverters::class,
    StoriesTypeConverter::class,
    UrlTypeConverter::class,
    ComicsTypeConverter::class,
    EventsTypeConverter::class,
    SeriesTypeConverter::class
)

abstract class MarvelDatabase : RoomDatabase() {


    abstract fun getMarvelCharacterDao(): MarvelCharacterDao

    companion object {
        // Singleton prevents multiple
        // instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MarvelDatabase? = null

        fun getDatabase(context: Context): MarvelDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MarvelDatabase::class.java,
                    "marvel_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}