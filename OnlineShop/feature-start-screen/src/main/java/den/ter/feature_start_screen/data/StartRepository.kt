package den.ter.feature_start_screen.data

import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import den.ter.feature_start_screen.data.api.StartApiService


import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface
import retrofit2.Response
import javax.inject.Inject

class StartRepository @Inject constructor(private val api: StartApiService) : StartRepositoryInterface {
    override suspend fun getBestAndHots(): Response<BestAndHotModel> {
        return api.getBestAndHots()
    }

    override suspend fun getCart(): Response<CartModel> {
        return api.getCart()
    }
}