package den.ter.feature_start_screen.domain.usecase

import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.feature_start_screen.data.database.repository.BestRepository

class GetBestUseCase(private val repository: BestRepository) {
    fun execute() = repository.allBests
    suspend fun insert(list: List<BestSeller>) = repository.insertAll(list)
}