package den.ter.onlineshop.di


import android.telecom.Call
import den.ter.feature_cart_screen.data.CartRepository
import den.ter.feature_cart_screen.data.api.CartRetrofitInstance
import den.ter.feature_cart_screen.domain.repository.CartRepositoryInterface
import den.ter.feature_details_screen.data.DetailsRepository
import den.ter.feature_details_screen.data.api.DetailsRetrofitInstance
import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface
import den.ter.feature_start_screen.data.StartRepository
import den.ter.feature_start_screen.data.api.StartRetrofitInstance
import den.ter.feature_start_screen.domain.repository.StartRepositoryInterface
import org.koin.dsl.module

val dataModule = module {

    single<StartRetrofitInstance> {
        StartRetrofitInstance
    }

    single<StartRepositoryInterface> {
        StartRepository(retrofit = get())
    }

    single<DetailsRetrofitInstance> {
        DetailsRetrofitInstance
    }

    single<DetailsRepositoryInterface> {
        DetailsRepository(retrofit = get())
    }

    single<CartRetrofitInstance> {
        CartRetrofitInstance
    }

    single<CartRepositoryInterface> {
        CartRepository(retrofit = get())
    }

}