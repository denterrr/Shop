package den.ter.feature_cart_screen.di

import dagger.Module
import dagger.Provides
import den.ter.feature_cart_screen.data.api.CartApiService
import retrofit2.Retrofit
import retrofit2.create

@Module
class CartModule {

    @Provides
    fun provideCartApi(retrofit: Retrofit): CartApiService{
        return retrofit.create(CartApiService::class.java)
    }
}