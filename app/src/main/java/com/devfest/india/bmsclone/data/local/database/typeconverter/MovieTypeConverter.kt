package com.devfest.india.bmsclone.data.local.database.typeconverter

import androidx.room.TypeConverter
import com.devfest.india.bmsclone.data.local.database.entity.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object MovieTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromList(value: List<Movie>) = Gson().toJson(value)

    @TypeConverter
    @JvmStatic
    fun toList(value: String): List<Movie> {
        val listType: Type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value, listType)
    }

}