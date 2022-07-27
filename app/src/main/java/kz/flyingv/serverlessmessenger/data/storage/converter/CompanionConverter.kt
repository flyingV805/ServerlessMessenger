package kz.flyingv.serverlessmessenger.data.storage.converter

import androidx.room.TypeConverter
import kz.flyingv.serverlessmessenger.data.model.Companion
import org.json.JSONObject

class CompanionConverter {

    @TypeConverter
    fun from(companion: Companion): String{
        val json = JSONObject()

        return json.toString()
    }
/*
    @TypeConverter
    fun to(data: String): Companion?{

    }*/

}