package com.ahariss.test.mvvm.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahariss.test.mvvm.models.Events
import com.ahariss.test.mvvm.models.Series
import com.ahariss.test.mvvm.models.Stories
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
object SeriesTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Series? {
        val type: Type = object : TypeToken<Series?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromSeries(evetnts: Series?): String {
        val gson = Gson()
        return gson.toJson(evetnts)
    }
}