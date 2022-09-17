package den.ter.feature_start_screen.domain.usecase


import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface

class GetBestAndHotsUseCase(private val repository: StartRepositoryInterface) {
    suspend fun execute() = repository.getBestAndHots()
}