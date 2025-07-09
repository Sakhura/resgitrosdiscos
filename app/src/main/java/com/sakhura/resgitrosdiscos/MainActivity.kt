package com.sakhura.resgitrosdiscos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.sakhura.resgitrosdiscos.data.Product
import com.sakhura.resgitrosdiscos.ui.theme.AddProductScreen
import com.sakhura.resgitrosdiscos.ui.theme.CartScreen
import com.sakhura.resgitrosdiscos.ui.theme.ProductListScreen
import com.sakhura.resgitrosdiscos.ui.theme.ResgitrosDiscosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ResgitrosDiscosTheme {
                var screen by remember { mutableStateOf("products") }
                val cart = remember { mutableStateListOf<Product>() }
                val products = remember { mutableStateListOf<Product>() }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (screen) {
                        "products" -> {
                            ProductListScreen(
                                products = products,
                                onAddToCart = { cart.add(it) },
                                onGoToCart = { screen = "cart" },
                                onGoToAddProduct = { screen = "addProduct" },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        "addProduct" -> {
                            AddProductScreen(
                                onProductAdded = { products.add(it) },
                                onBack = { screen = "products" }
                            )
                        }

                        "cart" -> {
                            CartScreen(
                                cartItems = cart,
                                onBack = { screen = "products" },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}
