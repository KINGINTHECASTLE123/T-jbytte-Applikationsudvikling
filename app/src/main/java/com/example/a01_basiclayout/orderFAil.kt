package com.example.a01_basiclayout

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainFunction()
        }
    }
}


@Composable
fun MainFunction() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        OrderFail("Oh Snap! Order Failed", "Looks like something went wrong " +
                "while processing your request.") // Oh Snap! Order failed
        AlertImage()
    }
}

@Composable
fun OrderFail (topText: String, bottomText: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(text = topText,
            fontSize = 30.sp,
            lineHeight = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Column {
            Text(
                text = bottomText,
                fontSize = 15.sp,
                lineHeight = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun AlertImage (modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.alert)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    )
    {
        Image(
            painter = image,
            contentDescription = "Alert Image",
            modifier = Modifier
                .size(100.dp)
                .height(100.dp)
                .fillMaxSize()

        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainFunctionPreview() {
        MainFunction()
}