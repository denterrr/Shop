package den.ter.feature_start_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.feature_start_screen.data.database.dao.HotDao
import den.ter.feature_start_screen.domain.repository.HotRepositoryInterface

class HotRepository(private val hotDao: HotDao): HotRepositoryInterface {
    override val allHots: LiveData<List<HomeStore>>
        get() = hotDao.getHots()

    override suspend fun insertOne(model: HomeStore) {
        hotDao.insert(model)
    }

    override suspend fun insertAll(list: List<HomeStore>) {
        hotDao.insertAll(list)
    }
}