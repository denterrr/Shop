package den.ter.feature_start_screen.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.feature_start_screen.data.database.dao.BestDao
import den.ter.feature_start_screen.data.database.dao.HotDao

@Database(entities = [HomeStore::class], version = 1)
abstract class HotDatabase: RoomDatabase() {


    abstract fun getHotDao(): HotDao

    companion object{
        private var startDatabase: HotDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): HotDatabase{
            return if(startDatabase==null){
                startDatabase = Room.databaseBuilder(context,HotDatabase::class.java,"db2").build()
                startDatabase as HotDatabase
            }else{
                startDatabase as HotDatabase
            }
        }
    }
}