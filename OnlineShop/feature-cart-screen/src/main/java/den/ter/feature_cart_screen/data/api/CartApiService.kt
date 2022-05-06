package den.ter.feature_cart_screen.data.api

import den.ter.core.models.cartmodel.CartModel
import retrofit2.Response
import retrofit2.http.GET

interface CartApiService {
    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): Response<CartModel>
}