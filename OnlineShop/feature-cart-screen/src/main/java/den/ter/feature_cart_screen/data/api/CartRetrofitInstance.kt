package den.ter.feature_cart_screen.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CartRetrofitInstance {
    val BASE_URL = "https://run.mocky.io/"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: CartApiService by lazy{
        retrofit.create(CartApiService::class.java)
    }
}