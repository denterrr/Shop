package den.ter.feature_cart_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel

interface CartDatabaseRepositoryInterface {
    val cart: LiveData<CartModel>

    suspend fun insert(model: CartModel)

}