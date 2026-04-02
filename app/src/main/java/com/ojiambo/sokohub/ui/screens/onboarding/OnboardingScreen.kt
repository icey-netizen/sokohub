package com.jonathan.sokohub.ui.screens.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ojiambo.sokohub.R
import kotlinx.coroutines.yield

@Composable
fun OnboardingScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        Image(
            painter = painterResource(R.drawable.product),
            contentDescription = "product icon",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "WELCOME TO SOKOHUB",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center




        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Shop Smater",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif ,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "We Provide a centralized platform for you to simplify daily operations",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif

        )
        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Green),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        ) {
            Text(text = "Get Started")
        }









    }
}
@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen()
}