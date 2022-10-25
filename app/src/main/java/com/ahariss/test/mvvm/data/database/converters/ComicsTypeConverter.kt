package com.ahariss.test.mvvm.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahariss.test.mvvm.models.Comic
import com.ahariss.test.mvvm.models.Comics
import com.ahariss.test.mvvm.models.Thumbnail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

@ProvidedTypeConverter
object ComicsTypeConverter {

    @TypeConverter
    fun fromString(value: String?): Comics? {
        val listType: Type = object : TypeToken<Comics>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromComics(list: Comics?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}