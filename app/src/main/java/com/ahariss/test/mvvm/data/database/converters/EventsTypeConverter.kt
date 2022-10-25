package com.ahariss.test.mvvm.data.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ahariss.test.mvvm.models.Events
import com.ahariss.test.mvvm.models.Stories
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
object EventsTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Events? {
        val type: Type = object : TypeToken<Events?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromEvents(events: Events?): String {
        val gson = Gson()
        return gson.toJson(events)
    }
}