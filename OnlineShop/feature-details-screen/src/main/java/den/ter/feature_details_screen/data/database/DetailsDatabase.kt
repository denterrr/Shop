package den.ter.feature_details_screen.data.database

import android.content.Context
import androidx.room.*
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.detailmodel.DetailConverter
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_details_screen.data.database.dao.DetailsDao


@Database(entities = [DetailModel::class], version = 1)
@TypeConverters(DetailConverter::class)
abstract class DetailsDatabase: RoomDatabase() {


    abstract fun getDetailsDao(): DetailsDao

    companion object{
        private var startDatabase: DetailsDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): DetailsDatabase{
            return if(startDatabase==null){
                startDatabase = Room.databaseBuilder(context,DetailsDatabase::class.java,"db3").build()
                startDatabase as DetailsDatabase
            }else{
                startDatabase as DetailsDatabase
            }
        }
    }
}