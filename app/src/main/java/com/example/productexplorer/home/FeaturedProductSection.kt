package com.example.productexplorer.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ProductUi
import com.example.productexplorer.shared.AppCard

@Composable
fun FeaturedProductSection(
    modifier: Modifier = Modifier,
    product: ProductUi,
    onClick: () -> Unit,
){
    AppCard(modifier = modifier.fillMaxWidth()) {
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
        ProductQuickInfoRow(
            rating = product.rating,
            price = product.price,
            stock = product.stock,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary
            ),
            modifier = Modifier.align(Alignment.End).padding(top = 28.dp)
        ) {
            Text(text = "Voir le produit", )
        }
    }
}