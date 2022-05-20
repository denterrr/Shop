package den.ter.feature_details_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.detailmodel.DetailModel

interface DetailsDatabaseRepositoryInterface {
    val details: LiveData<DetailModel>

    suspend fun insert(model: DetailModel)

}