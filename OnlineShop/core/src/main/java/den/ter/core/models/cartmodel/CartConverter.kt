package den.ter.core.models.cartmodel

import android.os.Build
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import java.util.Arrays.asList
import java.util.stream.Collectors

class CartConverter {


    @TypeConverter
    fun fromList(list: List<Basket>): String = Gson().toJson(list)

    @TypeConverter
    fun fromString(data: String): List<Basket> = Gson().fromJson(data, Array<Basket>::class.java).toList()
}