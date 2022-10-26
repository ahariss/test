package com.ahariss.test.mvvm.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ahariss.test.mvvm.data.database.converters.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "marvelCharacter")
data class MarvelCharacter(
    @PrimaryKey
    val id: Int?,
    @TypeConverters(ComicsTypeConverter::class)
    val comics: Comics?,
    val description: String?,
    @TypeConverters(EventsTypeConverter::class)
    val events: Events?,
    val modified: String?,
    val name: String?,
    val resourceURI: String?,
    @TypeConverters(SeriesTypeConverter::class)
    val series: Series?,
    @TypeConverters(StoriesTypeConverter::class)
    val stories: Stories?,
    @TypeConverters(ThumbConverters::class)
    val thumbnail: Thumbnail?,
    @TypeConverters(UrlTypeConverter::class)
    val urls: List<Url>?
) : Parcelable