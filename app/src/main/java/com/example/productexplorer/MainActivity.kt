package com.example.productexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.productexplorer.catalog.ProductCatalogScreen
import com.example.productexplorer.home.ProductHomeScreen
import com.example.productexplorer.theme.ProductExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductExplorerTheme(darkTheme = true) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ProductHomeScreen(
//                        modifier = Modifier.padding(innerPadding),
//                        featuredProduct = sampleProduct(),
//                        onFeaturedProductClick = {}
//                    )
                    ProductCatalogScreen(
                        modifier = Modifier.padding(innerPadding),
                        products = sampleProducts(),
                        onProductClick = {}
                    )
                }
            }
        }
    }
}



