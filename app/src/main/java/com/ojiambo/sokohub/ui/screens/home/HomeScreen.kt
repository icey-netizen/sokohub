package com.ojiambo.sokohub.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojiambo.sokohub.R
import com.ojiambo.sokohub.navigation.ROUT_INTENT
import com.ojiambo.sokohub.ui.theme.LightTeal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //TopAppBar
        TopAppBar(
            title = {Text(text = "Home")},
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "" )
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "Search" )
                }

            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = LightTeal,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White,
                titleContentColor = Color.White
            )

        )
        //End of TopAppBar
        Spacer(modifier = Modifier.height(7.dp))
        //Start Of SearchBar
        var search by remember { mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = {search = it},
            modifier = Modifier.fillMaxWidth().padding(start = 7.dp, end = 7.dp),
            leadingIcon = {Icon(imageVector = Icons.Default.Search, contentDescription = "")},
            placeholder = {Text(text = "Search Products, Category")}
        )



        //End of SearchBar
        Spacer(modifier = Modifier.height(7.dp))

        Text(text = "Featured Products",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 15.dp)
            )
        Spacer(modifier = Modifier.height(7.dp))
        //Row
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery),
                    contentDescription = "grocery image",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Groceries",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 45.dp)
                )
                Button(
                    onClick = {navController.navigate(ROUT_INTENT)},
                    colors = ButtonDefaults.buttonColors(LightTeal
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 15.dp)

                ) {
                    Text(text = "Intent")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery),
                    contentDescription = "grocery image",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Groceries",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 45.dp)
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(LightTeal
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 15.dp)

                ) {
                    Text(text = "Shop Now!!")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery),
                    contentDescription = "grocery image",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Groceries",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 45.dp)
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(LightTeal
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 15.dp)

                ) {
                    Text(text = "Shop Now!!")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Image(
                    painter = painterResource(R.drawable.grocery),
                    contentDescription = "grocery image",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Groceries",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 45.dp)
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(LightTeal
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 15.dp)

                ) {
                    Text(text = "Shop Now!!")
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
        }

        //End of Row

    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}