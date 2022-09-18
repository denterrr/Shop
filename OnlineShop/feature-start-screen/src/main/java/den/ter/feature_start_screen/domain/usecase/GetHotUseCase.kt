package den.ter.feature_start_screen.domain.usecase

import den.ter.core.models.besthotmodel.HomeStore
import den.ter.feature_start_screen.domain.repository.HotRepositoryInterface

class GetHotUseCase(private val repository: HotRepositoryInterface) {
    fun execute() = repository.allHots
    suspend fun insert(list: List<HomeStore>) = repository.insertAll(list)
}