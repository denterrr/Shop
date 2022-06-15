package den.ter.feature_details_screen.domain.usecase

import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_details_screen.data.database.repository.DetailsDatabaseRepository
import javax.inject.Inject

class GetDetailsDbUseCase (private val detailsDatabaseRepository: DetailsDatabaseRepository) {
    fun execute() = detailsDatabaseRepository.details
    suspend fun insert(model: DetailModel) = detailsDatabaseRepository.insert(model)
}