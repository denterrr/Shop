package den.ter.feature_start_screen.data

import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import den.ter.feature_start_screen.data.api.StartRetrofitInstance

import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface
import retrofit2.Response

class StartRepository(private val retrofit: StartRetrofitInstance) : StartRepositoryInterface {
    override suspend fun getBestAndHots(): Response<BestAndHotModel> {
        return retrofit.apiService.getBestAndHots()
    }

    override suspend fun getCart(): Response<CartModel> {
        return retrofit.apiService.getCart()
    }
}