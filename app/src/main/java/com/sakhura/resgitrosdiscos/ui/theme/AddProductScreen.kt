package com.sakhura.resgitrosdiscos.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sakhura.resgitrosdiscos.R
import com.sakhura.resgitrosdiscos.data.Product

@Composable
fun AddProductScreen(
    onProductAdded: (Product) -> Unit,
    onBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Agregar nuevo disco", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre del disco") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Precio") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newProduct = Product(
                    id = (0..9999).random(),
                    name = name,
                    price = price.toDouble(),
                    imageResId = R.drawable.vinilo // imagen fija por ahora
                )
                onProductAdded(newProduct)
                onBack()
            },
            enabled = name.isNotBlank() && price.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Disco")
        }

        TextButton(onClick = onBack, modifier = Modifier.padding(top = 16.dp)) {
            Text("Cancelar")
        }
    }
}
