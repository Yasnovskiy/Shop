package com.example.shop

class Cart {
    private val products = mutableMapOf<Product, Int>()

    fun addProduct(product: Product) {
        if (products.containsKey(product)) {
            products[product] = products[product]!! + 1
        } else {
            products[product] = 1
        }
    }

    fun removeProduct(product: Product) {
        if (products.containsKey(product)) {
            val count = products[product]!!
            if (count > 1) {
                products[product] = count - 1
            } else {
                products.remove(product)
            }
        }
    }

    fun getTotalCount(): Int {
        return products.values.sum()
    }

    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for ((product, count) in products) {
            totalPrice += product.discountedPrice * count
        }
        return totalPrice
    }
}
