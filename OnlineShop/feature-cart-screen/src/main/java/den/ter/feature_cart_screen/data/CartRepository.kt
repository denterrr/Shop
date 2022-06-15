package den.ter.feature_cart_screen.data

import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_cart_screen.data.api.CartApiService

import den.ter.feature_cart_screen.domain.repository.CartRepositoryInterface
import retrofit2.Response
import javax.inject.Inject

class CartRepository @Inject constructor(private val apiService: CartApiService) :
    CartRepositoryInterface {

    override suspend fun getCart(): Response<CartModel> {
        return apiService.getCart()
    }

}