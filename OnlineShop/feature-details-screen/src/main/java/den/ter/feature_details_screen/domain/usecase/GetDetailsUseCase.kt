package den.ter.feature_details_screen.domain.usecase

import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface

class GetDetailsUseCase(private val repository: DetailsRepositoryInterface) {
    suspend fun execute() = repository.getDetails()
}