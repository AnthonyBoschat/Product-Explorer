package com.example.productexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.theme.ProductExplorerTheme

data class ProductUi(
    val title: String,
    val brand: String,
    val category: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val warrantyInformation: String,
    val shippingInformation: String
)

fun sampleProduct(): ProductUi{
    return ProductUi(
        title = "Smartphone Toto X",
        brand = "TotoTech",
        category = "Smartphones",
        description = "Un smartphone léger avec un écran lumineux, une bonne autonomie et un design moderne.",
        price = 699.99,
        discountPercentage = 12.5,
        rating = 4.6,
        stock = 34,
        warrantyInformation = "Garantie constructeur : 2 ans",
        shippingInformation = "Livraison estimée : 3 à 5 jours ouvrés"
    )
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductExplorerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductDetailScreen(
                        modifier = Modifier.padding(innerPadding),
                        product = sampleProduct(),
                        onAddToCartClick = {}
                    )
                }
            }
        }
    }
}


@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    product: ProductUi,
    onAddToCartClick: () -> Unit
){
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ){
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
        Text(text = "${product.price} €")
        Text(text = product.description)
        Button(onClick = onAddToCartClick){
            Text(text = "Ajouter au panier")
        }
    }
}


@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    productTitle: String,
){
    Image(
        modifier = modifier,
        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
        contentDescription = "Image du produit $productTitle",
    )
}

@Composable
fun ProductHeader(
    modifier:Modifier = Modifier,
    title: String,
    brand: String,
    category: String
){
    Column(modifier = modifier){
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Text(text = brand, style = MaterialTheme.typography.titleMedium)
        Text(text = category, style = MaterialTheme.typography.bodyMedium)
    }
}


@Composable
fun ProductPriceCard(
    modifier: Modifier = Modifier,
    price: Double,
    discountPercentage: Double,
){
    Card(modifier = modifier){
        Column(modifier = Modifier.padding(16.dp)){
            Text(
                text = "$price €",
                style= MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Remise : $discountPercentage %",
                style= MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview(){
    ProductExplorerTheme{
        ProductDetailScreen(
            product = sampleProduct(),
            onAddToCartClick = {}
        )
    }
}


