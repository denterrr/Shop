package den.ter.feature_details_screen.domain.repository

import den.ter.core.models.detailmodel.DetailModel
import retrofit2.Response

interface DetailsRepositoryInterface {
    suspend fun getDetails(): Response<DetailModel>
}