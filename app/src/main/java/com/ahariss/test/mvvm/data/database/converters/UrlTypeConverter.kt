package com.ahariss.test.mvvm.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahariss.test.mvvm.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

@ProvidedTypeConverter
object UrlTypeConverter {

    @TypeConverter
    fun fromString(value: String?): List<Url>? {
        val listType: Type = object : TypeToken<List<Url>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromComics(list: List<Url>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}