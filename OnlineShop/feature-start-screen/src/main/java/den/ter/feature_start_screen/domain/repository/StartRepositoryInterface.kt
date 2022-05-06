package den.ter.feature_start_screen.domain.repository


import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel


import retrofit2.Response

interface StartRepositoryInterface {

    suspend fun getBestAndHots(): Response<BestAndHotModel>

    suspend fun getCart(): Response<CartModel>
}