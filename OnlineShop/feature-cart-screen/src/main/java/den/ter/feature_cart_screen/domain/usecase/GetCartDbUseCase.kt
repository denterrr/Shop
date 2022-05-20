package den.ter.feature_cart_screen.domain.usecase

import den.ter.core.models.cartmodel.CartModel
import den.ter.feature_cart_screen.data.database.repository.CartDatabaseRepository

class GetCartDbUseCase(private val cartDatabaseRepository: CartDatabaseRepository) {
    fun execute() = cartDatabaseRepository.cart
    suspend fun insert(model: CartModel) = cartDatabaseRepository.insert(model)
}