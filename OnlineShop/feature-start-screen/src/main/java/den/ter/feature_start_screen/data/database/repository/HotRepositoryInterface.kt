package den.ter.feature_start_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore

interface HotRepositoryInterface {
    val allHots: LiveData<List<HomeStore>>

    suspend fun insertOne(model: HomeStore)
    suspend fun insertAll(list: List<HomeStore>)

}