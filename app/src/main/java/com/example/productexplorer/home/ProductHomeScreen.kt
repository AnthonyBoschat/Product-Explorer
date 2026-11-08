package com.example.productexplorer.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.product.sample.ProductUi
import com.example.productexplorer.ui.product.sample.sampleProduct
import com.example.productexplorer.ui.theme.ProductExplorerTheme

@Composable
fun ProductHomeScreen(
    featuredProduct: ProductUi,
    onFeaturedProductClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ){
        Text(
            text = "Product Explorer",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Découvrez les produits du moment",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}





@Preview(showBackground = true)
@Composable
fun ProductHomeScreenPreview() {
    ProductExplorerTheme {
        ProductHomeScreen(
            featuredProduct = sampleProduct(),
            onFeaturedProductClick = {}
        )
    }
}
