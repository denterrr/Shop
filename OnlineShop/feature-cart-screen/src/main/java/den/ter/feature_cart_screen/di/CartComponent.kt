package den.ter.feature_cart_screen.di

import dagger.Component
import den.ter.core.di.CoreComponent
import den.ter.feature_cart_screen.presentation.cart.CartFragment
import javax.inject.Scope

@CartScope
@Component(modules = [CartModule::class, CartRepoModule::class], dependencies = [CoreComponent::class])
interface CartComponent {
    fun inject(cartFragment: CartFragment)
}

@Scope
annotation class CartScope