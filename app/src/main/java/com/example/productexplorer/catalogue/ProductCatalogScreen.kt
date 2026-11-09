package com.example.productexplorer.catalogue

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productexplorer.product.components.ProductListItem
import com.example.productexplorer.ui.product.sample.ProductUi
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import com.example.productexplorer.product.components.CategoryRow
import com.example.productexplorer.ui.product.sample.sampleCategories
import com.example.productexplorer.ui.product.sample.sampleProducts
import com.example.productexplorer.ui.theme.ProductExplorerTheme


@Composable
fun ProductCatalogScreen(
    modifier: Modifier = Modifier,
    products: List<ProductUi>,
    onProductClick: (ProductUi) -> Unit
){
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Catalogue produits",
                style = MaterialTheme.typography.headlineMedium,
            )
        }
        item {
            Text(
                text = "Explorez une sélection de produits disponibles localement.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        item {
            CategoryRow(categories = sampleCategories())
        }

        items(
            items = products,
            key = { product -> product.id }
        ){
            product ->
                ProductListItem(
                    product = product,
                    onClick = { onProductClick(product)},
                )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProductCatalogScreenPreview(){
    ProductExplorerTheme{
        ProductCatalogScreen(
            products = sampleProducts(),
            onProductClick = {}
        )
    }
}