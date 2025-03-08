package com.example.a01_basiclayout.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a01_basiclayout.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePage()
        }
    }
}

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        AppHeader()         //Header med app-navn og ikoner
        CategoriesRow()     //Kategori-række
        Spacer(modifier = Modifier.height(8.dp))
        FilterSortBar()     //Filter og sorteringsbjælke
        Spacer(modifier = Modifier.height(16.dp))
        ClothesSection()    //Tøjkort-sektion
    }
}

@Composable
fun ClothesSection() {
    val clothes = listOf(
        ClothesItem("Brown knit", 50.00, R.drawable.brown_knit),
        ClothesItem("Green Shirt", 20.00, R.drawable.green_shirt),
        ClothesItem("Green Tee", 15.00, R.drawable.green_tee),
        ClothesItem("Black Vest", 35.00, R.drawable.black_vest)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(clothes) { item ->
            ClothesCard(item)
        }
    }
}

//Data-klasse for tøj
data class ClothesItem(
    val name: String,
    val price: Double,
    val imageRes: Int
)

@Composable
fun ClothesCard(item: ClothesItem) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.8f)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp),
                tint = Color.Black
            )
        }
        Text(text = item.name, fontWeight = FontWeight.Bold)
        Text(text = "${item.price} KR.", color = Color.Gray)
    }
}

//Header med app-navn og ikoner
@Composable
fun AppHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "teeSwap",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        HeaderIcons()
    }
}

//Ikoner i headeren
@Composable
fun HeaderIcons() {
    Row {
        listOf(
            Icons.Default.Notifications to "Notifications",
            Icons.Default.ShoppingCart to "Shopping cart",
            Icons.Default.FavoriteBorder to "Home",
            Icons.Default.Search to "Search",
            Icons.Default.Menu to "Menu"
        ).forEach { (icon, description) ->
            IconButton(onClick = { }) {
                Icon(
                    imageVector = icon,
                    contentDescription = description
                )
            }
        }
    }
}

//Kategori-række
@Composable
fun CategoriesRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOf("Popular", "Men", "Women", "Kids").forEachIndexed { index, category ->
            Text(
                text = category,
                fontSize = 16.sp,
                fontWeight = if (index == 0) FontWeight.Bold else FontWeight.Normal,
                color = if (index == 0) Color(0xFFFFC107) else Color.Gray
            )
        }
    }
}

//Simpel filter- og sorteringsbjælke
@Composable
fun FilterSortBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Text(
                text = "FILTER & SORT",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Outlined.Tune, contentDescription = "Filter", tint = Color.Black)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Outlined.Sort, contentDescription = "Sort", tint = Color.Black)
        }

        Row {
            Icon(imageVector = Icons.Outlined.GridView, contentDescription = "Grid", tint = Color.Black)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Outlined.ViewList, contentDescription = "List", tint = Color.Black)
        }
    }
}

//Forhåndsvisning af HomePage
/* @Preview(showBackground = true)
@Composable
fun PreviewHomepage() {
    HomePage()
} */