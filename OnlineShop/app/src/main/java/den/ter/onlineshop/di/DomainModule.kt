package den.ter.onlineshop.di


import den.ter.feature_cart_screen.domain.usecase.GetCartUseCase
import den.ter.feature_details_screen.domain.usecase.GetDetailsUseCase
import den.ter.feature_start_screen.domain.usecase.GetBestAndHotsUseCase
import den.ter.feature_start_screen.domain.usecase.GetCartCountUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetBestAndHotsUseCase> {
        GetBestAndHotsUseCase(repository = get())
    }

    factory<GetCartUseCase> {
        GetCartUseCase(repository = get())
    }

    factory<GetCartCountUseCase> {
        GetCartCountUseCase(repository = get())
    }


    factory<GetDetailsUseCase> {
        GetDetailsUseCase(repository = get())
    }

}