package den.ter.feature_start_screen.domain.usecase

import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.feature_start_screen.data.database.repository.BestRepository
import den.ter.feature_start_screen.data.database.repository.HotRepository

class GetHotUseCase(private val repository: HotRepository) {
    fun execute() = repository.allHots
    suspend fun insert(list: List<HomeStore>) = repository.insertAll(list)
}