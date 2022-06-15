package den.ter.feature_start_screen.di

import dagger.Module
import dagger.Provides
import den.ter.feature_start_screen.data.api.StartApiService
import retrofit2.Retrofit
import retrofit2.create

@Module
class StartModule {

    @Provides
    fun provideApi(retrofit: Retrofit): StartApiService{
        return retrofit.create(StartApiService::class.java)
    }
}