package den.ter.feature_start_screen.domain.usecase

import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface

class GetCartCountUseCase(private val repository: StartRepositoryInterface) {
    suspend fun execute() = repository.getCart()
}