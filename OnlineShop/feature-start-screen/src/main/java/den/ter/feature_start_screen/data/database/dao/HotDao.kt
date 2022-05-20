package den.ter.feature_start_screen.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore

@Dao
interface HotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: HomeStore)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<HomeStore>)

    @Query("SELECT * from hot_table")
    fun getHots(): LiveData<List<HomeStore>>
}