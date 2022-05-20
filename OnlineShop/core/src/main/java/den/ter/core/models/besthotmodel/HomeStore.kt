package den.ter.core.models.besthotmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hot_table")
data class HomeStore(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo
    val is_buy: Boolean,

    @ColumnInfo
    val is_new: Boolean,

    @ColumnInfo
    val picture: String,

    @ColumnInfo
    val subtitle: String,

    @ColumnInfo
    val title: String
)