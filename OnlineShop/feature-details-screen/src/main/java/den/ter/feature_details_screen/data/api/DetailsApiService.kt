package den.ter.feature_details_screen.data.api

import den.ter.core.models.detailmodel.DetailModel
import retrofit2.Response
import retrofit2.http.GET

interface DetailsApiService {
    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetails(): Response<DetailModel>
}