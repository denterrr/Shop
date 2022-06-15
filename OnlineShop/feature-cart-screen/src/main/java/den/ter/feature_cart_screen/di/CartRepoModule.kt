package den.ter.feature_cart_screen.di

import dagger.Binds
import dagger.Module
import den.ter.feature_cart_screen.data.CartRepository
import den.ter.feature_cart_screen.domain.repository.CartRepositoryInterface

@Module
interface CartRepoModule {

    @Binds
    fun bindCartRepo(repo: CartRepository): CartRepositoryInterface
}