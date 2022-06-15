package den.ter.feature_start_screen.domain.usecase


import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface
import javax.inject.Inject

class GetBestAndHotsUseCase @Inject constructor(private val repository: StartRepositoryInterface) {
    suspend fun execute() = repository.getBestAndHots()
}