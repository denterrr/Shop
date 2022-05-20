package den.ter.onlineshop.di

import den.ter.feature_cart_screen.presentation.cart.CartViewModel
import den.ter.feature_details_screen.presentation.product.ProductDetailViewModel
import den.ter.feature_start_screen.presentation.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<StartViewModel>{
        StartViewModel(
            getBestAndHotsUseCase = get(),
            getCartCountUseCase = get(),
            getBestUseCase = get(),
            getHotUseCase = get()
        )
    }

    viewModel<CartViewModel>{
        CartViewModel(
            getCartUseCase = get(),
            getCartDbUseCase = get()
        )
    }

    viewModel<ProductDetailViewModel>{
        ProductDetailViewModel(
            getDetailsUseCase = get(),
            getDetailsDbUseCase = get()
        )
    }
}