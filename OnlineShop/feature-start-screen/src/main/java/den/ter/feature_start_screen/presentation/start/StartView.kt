package den.ter.feature_start_screen.presentation.start

import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.cartmodel.CartModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface StartView: MvpView {
    fun getBestAndHots(resp: BestAndHotModel)
    fun getCartCount(cartModel: CartModel)
    fun getCartCount(i: Int)
}