package com.example.learncanva.attributes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncanva.attributes.ui.theme.LearnCanvaTheme

class RowAndColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnCanvaTheme {
                Column (
                    modifier = Modifier
                        .size(600.dp, 400.dp)
                        .background(Color.Red),

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                   FirstCall()
                   SecondCall()
                }
            }
        }
    }
}

@Composable
fun ColumnScope.FirstCall(){
    Surface(
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp)
            .background(Color.Blue),
        color = Color.Blue,
    ) {
        Greeting("Android")
    }
}

@Composable
fun ColumnScope.SecondCall(){
    Surface(
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp)
            .background(Color.Green),
        color = Color.Green,
    ) {
        Greeting("Sazzad")


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

        Text(
            modifier = modifier.size(200.dp),
            textAlign = TextAlign.Center,
            text = "Hello $name!",
            fontSize = 40.sp,
            color = Color.White,
        )



}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LearnCanvaTheme {
//        Greeting("Android")
//    }
//}