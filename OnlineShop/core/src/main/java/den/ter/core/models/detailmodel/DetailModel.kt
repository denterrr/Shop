package den.ter.core.models.detailmodel

import androidx.room.*


@Entity(tableName = "detail_table")
data class DetailModel(
    @ColumnInfo
    val CPU: String,
    @ColumnInfo
    val camera: String,
    @ColumnInfo
    val capacity: List<String>,
    @ColumnInfo
    val color: List<String>,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo
    val images: List<String>,
    @ColumnInfo
    val isFavorites: Boolean,
    @ColumnInfo
    val price: Int,
    @ColumnInfo
    val rating: Double,
    @ColumnInfo
    val sd: String,
    @ColumnInfo
    val ssd: String,
    @ColumnInfo
    val title: String
)