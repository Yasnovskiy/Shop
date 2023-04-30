package com.example.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val context: Context,
    private val products: List<Product>
) : ArrayAdapter<Product>(context, 0, products) {

    var onAddClickListener: ((Product) -> Unit)? = null
    var onRemoveClickListener: ((Product) -> Unit)? = null

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productName: TextView = itemView.findViewById(R.id.productName)
        var productPrice: TextView = itemView.findViewById(R.id.productPrice)
        var addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
        var removeFromCartButton: Button = itemView.findViewById(R.id.removeFromCartButton)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_product,
            parent,
            false
        );

        val holder: ProductViewHolder = view.tag as? ProductViewHolder ?: ProductViewHolder(view)
        view.tag = holder

        val product = products[position]

        holder.productName.text = product.name;
        holder.productPrice.text = String.format("%.2f", product.discountedPrice);

        holder.addToCartButton.setOnClickListener {
            onAddClickListener?.invoke(product)
        }

        holder.removeFromCartButton.setOnClickListener {
            onRemoveClickListener?.invoke(product)
        }

        return view
    }
}
