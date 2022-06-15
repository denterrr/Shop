package den.ter.feature_details_screen.domain.usecase

import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val repository: DetailsRepositoryInterface) {
    suspend fun execute() = repository.getDetails()
}