package den.ter.feature_start_screen.data.api


import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import retrofit2.Response
import retrofit2.http.GET

interface StartApiService {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getBestAndHots(): Response<BestAndHotModel>

    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): Response<CartModel>
}