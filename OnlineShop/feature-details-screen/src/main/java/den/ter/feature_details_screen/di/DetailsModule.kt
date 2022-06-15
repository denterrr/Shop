package den.ter.feature_details_screen.di

import dagger.Module
import dagger.Provides
import den.ter.feature_details_screen.data.api.DetailsApiService
import retrofit2.Retrofit
import retrofit2.create

@Module
class DetailsModule {

    @Provides
    fun provideDetailsApi(retrofit: Retrofit): DetailsApiService{
        return retrofit.create(DetailsApiService::class.java)
    }
}