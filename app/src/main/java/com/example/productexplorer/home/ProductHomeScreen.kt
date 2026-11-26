package com.example.productexplorer.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ProductUi
import com.example.productexplorer.sampleProduct
import com.example.productexplorer.theme.ProductExplorerTheme

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
            DailyOfferBox()
            Spacer(modifier = Modifier.height(24.dp))
            CategoriesSection()
            Spacer(modifier = Modifier.height(24.dp))
            FeaturedProductSection(
                product = featuredProduct,
                onClick = onFeaturedProductClick
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
}



@Preview
@Composable
fun ProductHomeScreenPreview() {
    ProductHomeScreenPreviewContent(darkTheme = false)
}

@Preview
@Composable
fun ProductHomeScreenDarkPreview() {
    ProductHomeScreenPreviewContent(darkTheme = true)
}

@Composable
private fun ProductHomeScreenPreviewContent(darkTheme: Boolean) {
    ProductExplorerTheme(darkTheme = darkTheme) {
        Scaffold { innerPadding ->
            ProductHomeScreen(
                modifier = Modifier.padding(innerPadding),
                featuredProduct = sampleProduct(),
                onFeaturedProductClick = {}
            )
        }
    }
}
