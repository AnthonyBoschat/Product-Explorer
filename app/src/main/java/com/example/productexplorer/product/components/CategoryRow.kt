package com.example.productexplorer.product.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productexplorer.home.components.CategoryChip
import androidx.compose.foundation.lazy.items

@Composable
fun CategoryRow(
    categories: List<String>,
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories){
            category -> CategoryChip(label = category)
        }
    }
}