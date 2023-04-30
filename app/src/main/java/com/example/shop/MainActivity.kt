package com.example.shop

import com.example.shop.ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val resultText: TextView = findViewById(R.id.result)
//        val numberInput: EditText = findViewById(R.id.number_input)
//        val formatButton: Button = findViewById(R.id.format_button)
//
////        val iphoneCase = Product(price = 123.5)
////        val priceFormatter: PriceFormatter = MyPriceFormatter()
////        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
//
//        formatButton.setOnClickListener {
////            val iphoneCase = Product(numberInput.text.toString().toDoubleOrNull() ?: 0.0)
////            val priceFormatter: PriceFormatter = MyPriceFormatter()
////            val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
////
////            resultText.text = priceFormatter.format(discountIphoneCasePrice)
//        }
//    }
//}

class MainActivity : AppCompatActivity() {

    private val products = mutableListOf<Product>()
    private val cart = Cart()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var productList: ListView = findViewById(R.id.productList);

        // Заполнение списка товаров
        products.add(Product("Product 1", 10.0, 9.0))
        products.add(Product("Product 2", 20.0, 18.0))
        products.add(Product("Product 3", 30.0, 27.0))

        // Настройка адаптера для списка товаров
        val adapter = ProductAdapter(this, products)
        productList.adapter = adapter

        // Обработка клика по кнопке "Добавить в корзину"
        adapter.onAddClickListener = { product ->
            cart.addProduct(product)
            updateCart()
        }

        // Обработка клика по кнопке "Удалить из корзины"
        adapter.onRemoveClickListener = { product ->
            cart.removeProduct(product)
            updateCart()
        }

        // Обновление корзины при запуске активности
        updateCart()
    }

    private fun updateCart() {
        var cartCount: TextView = findViewById(R.id.cartCount);
        var cartPrice: TextView = findViewById(R.id.cartPrice);

        val count = cart.getTotalCount()
        val price = cart.getTotalPrice()
        cartCount.text = count.toString()
        cartPrice.text = String.format("%.2f", price)
    }
}

