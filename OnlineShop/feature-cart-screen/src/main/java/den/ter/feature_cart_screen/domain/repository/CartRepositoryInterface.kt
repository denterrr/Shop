package den.ter.feature_cart_screen.domain.repository

import den.ter.core.models.cartmodel.CartModel
import retrofit2.Response

interface CartRepositoryInterface {
    suspend fun getCart(): Response<CartModel>
}