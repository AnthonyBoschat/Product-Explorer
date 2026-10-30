package com.example.productexplorer.ui.product.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddToCartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = "Ajouter au panier")
    }
}
