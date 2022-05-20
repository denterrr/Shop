package den.ter.core.models.besthotmodel


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "best_table")
data class BestSeller(
    @ColumnInfo
    val discount_price: Int,

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo
    val is_favorites: Boolean,

    @ColumnInfo
    val picture: String,

    @ColumnInfo
    val price_without_discount: Int,

    @ColumnInfo
    val title: String
) : Serializable