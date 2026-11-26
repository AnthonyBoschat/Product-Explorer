package com.example.productexplorer.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.productexplorer.shared.AppCard

@Composable
fun ProductAvailabilityCard(
    modifier: Modifier = Modifier,
    stock: Int,
    shippingInformation: String,
) {
    val stockLabel: String = if (stock > 1) "unités" else "unité"
    AppCard(modifier = modifier) {
        Text(
            text = "Disponibilité",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Stock : $stock $stockLabel",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = shippingInformation,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
