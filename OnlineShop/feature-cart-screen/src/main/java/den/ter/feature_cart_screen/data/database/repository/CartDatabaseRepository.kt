package den.ter.feature_cart_screen.data.database.repository

import androidx.lifecycle.LiveData
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel
import den.ter.feature_cart_screen.data.database.dao.CartDao

class CartDatabaseRepository(private val cartDao: CartDao): CartDatabaseRepositoryInterface {
    override val cart: LiveData<CartModel>
        get() = cartDao.getCart()

    override suspend fun insert(model: CartModel) {
        cartDao.insert(model)
    }

}