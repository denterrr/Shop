package den.ter.core.models.cartmodel

import den.ter.core.models.cartmodel.Basket

data class CartModel(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)