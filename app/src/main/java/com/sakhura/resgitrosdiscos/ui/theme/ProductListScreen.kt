package com.sakhura.resgitrosdiscos.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.sakhura.resgitrosdiscos.data.Product

@Composable
fun ProductListScreen(
    products: List<Product>,
    onAddToCart: (Product) -> Unit,
    onGoToCart: () -> Unit,
    onGoToAddProduct: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = onGoToCart,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Ir al carrito")
        }

        LazyColumn {
            items(products) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = painterResource(id = product.imageResId),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "Precio: $${product.price}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Button(onClick = { onAddToCart(product) }) {
                                Text(text = "Agregar al carrito")
                            }
                        }
                    }
                }
            }
        }
    }
}
