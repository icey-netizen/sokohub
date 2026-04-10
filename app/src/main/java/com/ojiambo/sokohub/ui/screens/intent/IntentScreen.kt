package com.ojiambo.sokohub.ui.screens.intent

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ojiambo.sokohub.ui.theme.LightTeal


@SuppressLint("QueryPermissionsNeeded")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //Variables
        val mContext = LocalContext.current

        //TopAppBar
        TopAppBar(
            title = {Text(text = "Intent")},
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
        Spacer(modifier = Modifier.width(10.dp))

        //Buttons

        //STK Button/Mpesa Button
        OutlinedButton(
            onClick = {

                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

            },

            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),


        ) {
            Text(text = "Pay Via Mpesa")


        }
        //End of STK Button
        Spacer(modifier = Modifier.width(10.dp))
        // EmailButton
        OutlinedButton(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("viny4457@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                mContext.startActivity(shareIntent)
            },

            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Email")


        }
        Spacer(modifier = Modifier.width(10.dp))

        //End of Email

        //Message Button
        OutlinedButton(
            onClick = {
                val smsIntent=Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0788436117".toUri()
                smsIntent.putExtra("sms_body","Hello Vincent,how was your day?")
                mContext.startActivity(smsIntent)
            },

            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Send Message")


        }
        //End ot Email Button
        Spacer(modifier = Modifier.width(10.dp))

        //Call Button

        OutlinedButton(
            onClick = {
                val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0788436117".toUri()
                mContext.startActivity(callIntent)
            },

            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Call")


        }
        //End of Call Button
        Spacer(modifier = Modifier.width(10.dp))

        //Share Button

        OutlinedButton(
            onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://github.com/icey-netizen")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            },

            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Share")


        }
        //End of Share Button

        Spacer(modifier = Modifier.width(10.dp))

        //Camera Button

        OutlinedButton(
            onClick = {
                val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                    mContext.startActivity(cameraIntent)
                }else{
                    println("Camera app is not available")
                }
            },

            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Camera")


        }
        //End of Camera Button

        Spacer(modifier = Modifier.width(10.dp))


        //End of Buttons

    }



    }




@Preview(showBackground = true)
@Composable
fun IntentScreenPreview(){
    IntentScreen(rememberNavController())
}