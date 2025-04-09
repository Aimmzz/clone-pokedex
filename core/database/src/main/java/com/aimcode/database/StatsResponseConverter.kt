package com.aimcode.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.aimcode.model.PokemonInfo
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

@ProvidedTypeConverter
class StatsResponseConverter @Inject constructor(
    private val json: Json,
) {

    @TypeConverter
    fun fromString(value: String): List<PokemonInfo.StatsResponse>? {
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun fromInfoType(type: List<PokemonInfo.StatsResponse>?): String {
        return json.encodeToString(type)
    }
}