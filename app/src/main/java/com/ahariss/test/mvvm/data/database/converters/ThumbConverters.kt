package com.ahariss.test.mvvm.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahariss.test.mvvm.models.Thumbnail
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
object ThumbConverters {
    @TypeConverter
    fun fromString(value: String?): Thumbnail? {
        val listType: Type = object : TypeToken<Thumbnail?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromThumb(list: Thumbnail?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}