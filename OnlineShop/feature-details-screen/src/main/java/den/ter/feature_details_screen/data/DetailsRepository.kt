package den.ter.feature_details_screen.data

import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_details_screen.data.api.DetailsRetrofitInstance
import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface


import retrofit2.Response

class DetailsRepository(private val retrofit: DetailsRetrofitInstance):
    DetailsRepositoryInterface {


    override suspend fun getDetails(): Response<DetailModel>{
        return retrofit.apiService.getDetails()
    }
}