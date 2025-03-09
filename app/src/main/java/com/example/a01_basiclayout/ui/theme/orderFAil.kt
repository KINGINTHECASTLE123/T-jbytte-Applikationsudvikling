package com.example.a01_basiclayout.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a01_basiclayout.R


class OtherMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ErrorScreen()
        }
    }
}


@Composable
fun ErrorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ErrorContent("Oh Snap! Order Failed", "Looks like something went wrong " +
                "while processing your request.")
        TryAgainButton() // Render Button to try again
        BackToHome() // Render button to return home
        BackButton() // Button top left to return to previous page
    }
}

@Composable
fun ErrorContent (topText: String, bottomText: String) {
    val alertImage = painterResource(id = R.drawable.alert)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .offset(y = (-65).dp)
    )
    {
        Image(
            painter = alertImage,
            contentDescription = "Alert Image",
            modifier = Modifier.size(100.dp)
        )
        Spacer(
            modifier = Modifier.height(45.dp)
        )
        Text(text = topText,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = bottomText,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
    }
}

@Composable
fun TryAgainButton () {
    Button(
        onClick = { /* add logic later */ },
        border = BorderStroke(4.dp, Color.White),
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFFFC107)),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(55.dp)
            .offset(y = (-32).dp)
    ) {
        Text(
            text = "Please Try Again",
            fontSize = 14.sp
            )
    }
}

@Composable
fun BackToHome() {
    Row(
        modifier = Modifier
            .clickable { /* future function */ }
            .offset(y = (-20).dp)
            .offset(x = (-7).dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(15.dp)
        )
        Spacer(modifier = Modifier
            .width(5.dp)
        )
        Text(
            text = "Back to home",
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BackButton () {
    Row(
        modifier = Modifier
            .clickable { /* future function */ }
            .offset(y = (-510).dp)
            .offset(x = (-155).dp)
    )
    {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(30.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainFunctionPreview() {
        ErrorScreen()
}