package den.ter.feature_details_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_details_screen.data.database.dao.DetailsDao

class DetailsDatabaseRepository(private val detailsDao: DetailsDao): DetailsDatabaseRepositoryInterface {
    override val details: LiveData<DetailModel>
        get() = detailsDao.getDetails()

    override suspend fun insert(model: DetailModel) {
        detailsDao.insert(model)
    }

}