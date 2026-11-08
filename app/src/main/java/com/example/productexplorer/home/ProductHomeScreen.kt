package com.example.productexplorer.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.home.components.FeaturedProductSection
import com.example.productexplorer.home.components.HomeHeader
import com.example.productexplorer.home.components.SearchPreviewBar
import com.example.productexplorer.ui.product.sample.ProductUi
import com.example.productexplorer.ui.product.sample.sampleProduct
import com.example.productexplorer.ui.theme.ProductExplorerTheme

@Composable
fun ProductHomeScreen(
    featuredProduct: ProductUi,
    onFeaturedProductClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        HomeHeader()
        Spacer(modifier = Modifier.height(24.dp))
        SearchPreviewBar()
        Spacer(modifier = Modifier.height(24.dp))
        FeaturedProductSection(
            product = featuredProduct,
            onClick = onFeaturedProductClick
        )
        Spacer(modifier = Modifier.height(24.dp))
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
