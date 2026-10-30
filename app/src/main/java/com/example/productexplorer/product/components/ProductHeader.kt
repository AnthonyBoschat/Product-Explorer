package com.example.productexplorer.ui.product.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductHeader(
    modifier: Modifier = Modifier,
    title: String,
    brand: String,
    category: String
) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Text(text = brand, style = MaterialTheme.typography.titleMedium)
        Text(text = category, style = MaterialTheme.typography.bodyMedium)
    }
}
