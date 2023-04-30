package com.example.shop

import org.junit.Test
import com.example.shop.formatDouble
import com.example.shop.Product

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_print_hello() {
        print("hello")
    }

    @Test
    fun example() {
        val iphoneCase = Product(price = 123.5)
        val priceFormatter: PriceFormatter = MyPriceFormatter()
        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        println(priceFormatter.format(discountIphoneCasePrice))
    }
}
