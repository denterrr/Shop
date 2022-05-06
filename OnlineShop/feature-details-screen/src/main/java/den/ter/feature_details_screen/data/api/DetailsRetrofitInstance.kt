package den.ter.feature_details_screen.data.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DetailsRetrofitInstance {

    val BASE_URL = "https://run.mocky.io/"

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: DetailsApiService by lazy{
        retrofit.create(DetailsApiService::class.java)
    }
}