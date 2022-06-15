package den.ter.feature_cart_screen.domain.usecase

import den.ter.feature_cart_screen.domain.repository.CartRepositoryInterface
import javax.inject.Inject

class GetCartUseCase @Inject constructor(private val repository: CartRepositoryInterface) {
    suspend fun execute() = repository.getCart()
}