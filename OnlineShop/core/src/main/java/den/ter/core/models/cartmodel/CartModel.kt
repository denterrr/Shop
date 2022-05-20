package den.ter.core.models.cartmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import den.ter.core.models.cartmodel.Basket

@Entity(tableName = "cart_table")
data class CartModel(

    @ColumnInfo
    val basket: List<Basket>,
    @ColumnInfo
    val delivery: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo
    val total: Int
)