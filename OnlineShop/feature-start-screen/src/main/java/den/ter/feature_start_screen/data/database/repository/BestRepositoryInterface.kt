package den.ter.feature_start_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller

interface BestRepositoryInterface {
    val allBests: LiveData<List<BestSeller>>

    suspend fun insertOne(model: BestSeller)
    suspend fun insertAll(list: List<BestSeller>)

}