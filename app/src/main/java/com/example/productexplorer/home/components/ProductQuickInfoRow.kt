package com.example.productexplorer.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductQuickInfoRow(
    modifier : Modifier = Modifier,
    rating: Double,
    price: Double,
    stock: Int,
){
    Row(modifier = modifier.fillMaxWidth()){
        Text(
            text = "$price €",
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "★ $rating",
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "$stock en stock",
            modifier = Modifier.weight(1f)
        )
    }
}