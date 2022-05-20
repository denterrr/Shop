package den.ter.feature_start_screen.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.besthotmodel.BestSeller

@Dao
interface BestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: BestSeller)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<BestSeller>)

    @Query("SELECT * from best_table")
    fun getBests(): LiveData<List<BestSeller>>
}