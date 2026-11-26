package com.example.productexplorer.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.productexplorer.shared.AppCard

@Composable
fun ProductPriceCard(
    modifier: Modifier = Modifier,
    price: Double,
    discountPercentage: Double,
) {
    AppCard(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.onTertiary
    ) {
        Text(
            text = "$price €",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Remise : $discountPercentage %",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
