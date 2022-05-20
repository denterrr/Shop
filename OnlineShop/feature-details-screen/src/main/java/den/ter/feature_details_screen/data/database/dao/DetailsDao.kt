package den.ter.feature_details_screen.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.detailmodel.DetailModel

@Dao
interface DetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: DetailModel)


    @Query("SELECT * from detail_table")
    fun getDetails(): LiveData<DetailModel>

}