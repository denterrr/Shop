package den.ter.feature_start_screen.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StartRetrofitInstance {

    val BASE_URL = "https://run.mocky.io/"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService:StartApiService by lazy{
        retrofit.create(StartApiService::class.java)
    }
}