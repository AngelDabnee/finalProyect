package com.angeldabnee.inventary

data class ProductStock(
    val id:Int,
    val name: String,
    val price: Double,
    val quantity: Int,
    val unit: String,
    val image: String
)
