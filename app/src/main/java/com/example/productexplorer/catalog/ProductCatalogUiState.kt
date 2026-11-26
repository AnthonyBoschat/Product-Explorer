package com.example.productexplorer.catalog

import com.example.productexplorer.ProductUi

data class ProductCatalogUiState(
    val products: List<ProductUi> = emptyList(),
    val categories: List<String> = emptyList(),
    val searchQuery: String = "",
    val showOnlyInStock: Boolean = false,
    val showOnlyFavorite: Boolean = false,
    val favoriteProductIds: List<Int> = emptyList()
)