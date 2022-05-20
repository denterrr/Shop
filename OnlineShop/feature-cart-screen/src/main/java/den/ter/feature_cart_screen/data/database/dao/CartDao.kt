package den.ter.feature_cart_screen.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import den.ter.core.models.besthotmodel.BestAndHotModel
import den.ter.core.models.besthotmodel.BestSeller
import den.ter.core.models.besthotmodel.HomeStore
import den.ter.core.models.cartmodel.CartModel
import den.ter.core.models.detailmodel.DetailModel

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: CartModel)


    @Query("SELECT * from cart_table")
    fun getCart(): LiveData<CartModel>

}