package den.ter.feature_start_screen.domain.usecase

import den.ter.core.models.besthotmodel.BestSeller
import den.ter.feature_start_screen.domain.repository.BestRepositoryInterface

class GetBestUseCase(private val repository: BestRepositoryInterface) {
    fun execute() = repository.allBests
    suspend fun insert(list: List<BestSeller>) = repository.insertAll(list)
}