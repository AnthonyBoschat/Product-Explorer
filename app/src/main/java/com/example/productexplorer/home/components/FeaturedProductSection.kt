package com.example.productexplorer.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.product.sample.ProductUi

@Composable
fun FeaturedProductSection(
    modifier: Modifier = Modifier,
    product: ProductUi,
    onClick: () -> Unit,
){
    Surface (
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        tonalElevation = 4.dp
    ){
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = "Produit mis en avant",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = product.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = product.brand,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onClick) {
                Text(text = "Voir le produit")
            }
        }
    }
}