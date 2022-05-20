package den.ter.feature_cart_screen.data.database

import android.content.Context
import androidx.room.*
import den.ter.core.models.cartmodel.CartConverter
import den.ter.core.models.cartmodel.CartModel
import den.ter.feature_cart_screen.data.database.dao.CartDao

@Database(entities = [CartModel::class], version = 1)
@TypeConverters(CartConverter::class)
abstract class CartDatabase: RoomDatabase() {
    abstract fun getCartDao(): CartDao

    companion object{
        private var startDatabase: CartDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): CartDatabase{
            return if(startDatabase==null){
                startDatabase = Room.databaseBuilder(context,CartDatabase::class.java,"db4").build()
                startDatabase as CartDatabase
            }else{
                startDatabase as CartDatabase
            }
        }
    }
}