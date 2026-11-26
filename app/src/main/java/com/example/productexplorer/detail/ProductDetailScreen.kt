package com.example.productexplorer.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ProductUi
import com.example.productexplorer.sampleProduct
import com.example.productexplorer.sampleProductOutOfStock
import com.example.productexplorer.theme.ProductExplorerTheme

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    product: ProductUi,
    onAddToCartClick: () -> Unit
) {
    Surface() {

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        ProductImage(
            productTitle = product.title,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )
        ProductHeader(
            title = product.title,
            brand = product.brand,
            category = product.category,
        )
        ProductPriceCard(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            price = product.price,
            discountPercentage = product.discountPercentage
        )
        ProductAvailabilityCard(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            stock = product.stock,
            shippingInformation = product.shippingInformation,
        )
        ProductRating(
            rating = product.rating,
            modifier = Modifier.padding(top = 16.dp)
        )
        ProductDescription(
            modifier = Modifier.padding(top = 16.dp),
            description = product.description
        )
        ProductWarrantyField(
            warrantyInformation = product.warrantyInformation,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )
        AddToCartButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )
    }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    ProductExplorerTheme {
        ProductDetailScreen(
            product = sampleProduct(),
            onAddToCartClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductOutOfStockDetailScreenPreview() {
    ProductExplorerTheme(darkTheme = true) {
        ProductDetailScreen(
            product = sampleProduct(),
            onAddToCartClick = {}
        )
    }
}
