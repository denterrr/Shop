package den.ter.onlineshop.di


import android.telecom.Call
import den.ter.feature_cart_screen.data.CartRepository
import den.ter.feature_cart_screen.data.api.CartRetrofitInstance
import den.ter.feature_cart_screen.data.database.CartDatabase
import den.ter.feature_cart_screen.data.database.dao.CartDao
import den.ter.feature_cart_screen.data.database.repository.CartDatabaseRepository
import den.ter.feature_cart_screen.domain.repository.CartRepositoryInterface
import den.ter.feature_details_screen.data.DetailsRepository
import den.ter.feature_details_screen.data.api.DetailsRetrofitInstance
import den.ter.feature_details_screen.data.database.DetailsDatabase
import den.ter.feature_details_screen.data.database.dao.DetailsDao
import den.ter.feature_details_screen.data.database.repository.DetailsDatabaseRepository
import den.ter.feature_details_screen.domain.repository.DetailsRepositoryInterface
import den.ter.feature_start_screen.data.StartRepository
import den.ter.feature_start_screen.data.api.StartRetrofitInstance
import den.ter.feature_start_screen.data.database.BestDatabase
import den.ter.feature_start_screen.data.database.HotDatabase
import den.ter.feature_start_screen.data.database.dao.BestDao
import den.ter.feature_start_screen.data.database.dao.HotDao
import den.ter.feature_start_screen.data.database.repository.BestRepository
import den.ter.feature_start_screen.data.database.repository.HotRepository
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

    single<BestDao>{
        BestDatabase.getInstance(context = get()).getBestDao()
    }

    single<BestRepository>{
        BestRepository(bestDao = get())
    }

    single<HotDao>{
        HotDatabase.getInstance(context = get()).getHotDao()
    }

    single<HotRepository>{
        HotRepository(hotDao = get())
    }

    single<DetailsDao>{
        DetailsDatabase.getInstance(context = get()).getDetailsDao()
    }

    single<DetailsDatabaseRepository>{
        DetailsDatabaseRepository(detailsDao = get())
    }

    single<CartDao>{
        CartDatabase.getInstance(context = get()).getCartDao()
    }

    single<CartDatabaseRepository>{
        CartDatabaseRepository(cartDao = get())
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