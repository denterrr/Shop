package den.ter.feature_details_screen.di

import dagger.Component
import den.ter.core.di.CoreComponent
import den.ter.feature_details_screen.presentation.product.ProductDetailFragment
import javax.inject.Scope

@Component(modules = [DetailsModule::class, DetailsRepoModule::class], dependencies = [CoreComponent::class])
@DetailsScope
interface DetailsComponent {
    fun inject(productDetailFragment: ProductDetailFragment)
}

@Scope
annotation class DetailsScope