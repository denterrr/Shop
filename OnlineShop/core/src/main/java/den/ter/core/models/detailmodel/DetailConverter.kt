package den.ter.core.models.detailmodel

import android.os.Build
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import java.util.Arrays.asList
import java.util.stream.Collectors

class DetailConverter {


    @TypeConverter
    fun fromList(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromString(data: String): List<String> {
        val listType =object: TypeToken<List<String>>(){}.type
        return Gson().fromJson(data,listType)
    }
}