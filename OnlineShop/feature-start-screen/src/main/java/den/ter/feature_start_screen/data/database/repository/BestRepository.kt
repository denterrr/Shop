package den.ter.feature_start_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.feature_start_screen.data.database.dao.BestDao
import den.ter.feature_start_screen.domain.repository.BestRepositoryInterface

class BestRepository(private val bestDao: BestDao): BestRepositoryInterface {
    override val allBests: LiveData<List<BestSeller>>
        get() = bestDao.getBests()

    override suspend fun insertOne(model: BestSeller) {
        bestDao.insert(model)
    }

    override suspend fun insertAll(list: List<BestSeller>) {
        bestDao.insertAll(list)
    }
}