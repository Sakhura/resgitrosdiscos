package com.sakhura.resgitrosdiscos.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sakhura.resgitrosdiscos.data.Product
import androidx.compose.foundation.lazy.items

@Composable
fun CartScreen(
    cartItems: List<Product>,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
){
    val total = cartItems.sumOf { it.price}

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
        LazyColumn(modifier = Modifier.weight(1f)) {
         items(cartItems){product ->
             Text("${product.name} - $${String.format("%.2f", product.price)}")
            }
        }
        Text("Total: $${"%.2f".format(total)}", style = MaterialTheme.typography.titleLarge)
    }
}