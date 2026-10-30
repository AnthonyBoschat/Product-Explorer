package com.example.productexplorer.ui.product.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    productTitle: String,
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
        contentDescription = "Image du produit $productTitle",
    )
}
