package den.ter.feature_details_screen.data

import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_details_screen.data.api.DetailsApiService
import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface


import retrofit2.Response
import javax.inject.Inject

class DetailsRepository @Inject constructor(val apiService: DetailsApiService):
    DetailsRepositoryInterface {


    override suspend fun getDetails(): Response<DetailModel>{
        return apiService.getDetails()
    }
}