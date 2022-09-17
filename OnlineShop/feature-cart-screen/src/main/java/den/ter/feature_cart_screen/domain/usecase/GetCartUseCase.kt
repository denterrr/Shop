package den.ter.feature_cart_screen.domain.usecase

import den.ter.feature_cart_screen.domain.repository.CartRepositoryInterface

class GetCartUseCase (private val repository: CartRepositoryInterface) {
    suspend fun execute() = repository.getCart()
}