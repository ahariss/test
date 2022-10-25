package com.ahariss.test.mvvm.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahariss.test.mvvm.models.Stories
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
object StoriesTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Stories? {
        val listType: Type = object : TypeToken<Stories?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromThumb(list: Stories?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}