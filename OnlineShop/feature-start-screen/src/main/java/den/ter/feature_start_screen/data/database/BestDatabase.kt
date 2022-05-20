package den.ter.feature_start_screen.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.feature_start_screen.data.database.dao.BestDao

@Database(entities = [BestSeller::class], version = 1)
abstract class BestDatabase: RoomDatabase() {


    abstract fun getBestDao(): BestDao

    companion object{
        private var startDatabase: BestDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): BestDatabase{
            return if(startDatabase==null){
                startDatabase = Room.databaseBuilder(context,BestDatabase::class.java,"db").build()
                startDatabase as BestDatabase
            }else{
                startDatabase as BestDatabase
            }
        }
    }
}