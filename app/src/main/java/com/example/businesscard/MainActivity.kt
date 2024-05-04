package com.example.businesscard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardApp()
        }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        BusinessCard()
    }
}

@Preview
@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7EF))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoAndInfo()
        Spacer(modifier = Modifier.height(32.dp))
        ContactInfo()
    }
}

@Composable
fun LogoAndInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sajid Wasif",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Computer Science Student",
            color = Color.Gray,
            fontSize = 18.sp
        )
    }
}

@Composable
fun ContactInfo() {

    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ContactItem(
            icon = Icons.Filled.Phone,
            text = "01932600658",
            iconTint = Color(0xFF03DAC5),
            onClick = {
                val phoneUri = Uri.parse("tel:+8801932600658")
                val phoneIntent = Intent(Intent.ACTION_DIAL, phoneUri)
                context.startActivity(phoneIntent)
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContactItem(
            icon = Icons.Filled.Email,
            text = "Sajid.wasif.sw@gmail.com",
            iconTint = Color(0xFF03DAC5),
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:Samiha.sadaf@gmail.com"))
                context.startActivity(Intent.createChooser(emailIntent, "Send Email"))
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContactItem(
            icon = Icons.Filled.Link,
            text = "sajid.wasif5",
            iconTint = Color(0xFF03DAC5),
            onClick = {
                val webpageUri = Uri.parse("http://www.example.com")
                val webIntent = Intent(Intent.ACTION_VIEW, webpageUri)
                context.startActivity(webIntent)
            }
        )
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String, iconTint: Color, onClick: () -> Unit) {
    Row(
        modifier = Modifier.clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}
