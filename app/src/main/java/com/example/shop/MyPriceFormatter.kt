package com.example.shop

class MyPriceFormatter(): PriceFormatter {

    override fun format(price: Double): String {
        if (price % 1 == 0.0) {
            return price.toInt().toString()
        } else {
            return String.format("%.2f", price)
        }
    }

}