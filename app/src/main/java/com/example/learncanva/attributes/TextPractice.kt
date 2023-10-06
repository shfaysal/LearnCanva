package com.example.learncanva.attributes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncanva.R
import com.example.learncanva.attributes.ui.theme.LearnCanvaTheme

class TextPractice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnCanvaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(Color.Yellow)
                                .padding(2.dp),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Subscript(
                                text = "Script",
                                subtext = "Demo",
                                supertext = "Demo"
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .background(Color.Yellow)
                                .padding(2.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BrushForText()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Subscript(
    text : String,
    subtext : String,
    supertext : String
){
    val subAnnotatedString = buildAnnotatedString {
        append(text)

        withStyle(
            SpanStyle(
                baselineShift = BaselineShift.Subscript,
                fontSize = 20.sp,
                shadow = Shadow(
                    color = Color.Green,
                    offset = Offset(0f, -2f),
                    blurRadius = 2f
                )
            )
        ){
            append(subtext)
        }
    }

    val superAnnotatedString = buildAnnotatedString {
        append(text)

        withStyle(
            SpanStyle(
                baselineShift = BaselineShift.Superscript,
                fontSize = 20.sp,
                shadow = Shadow(
                    color = Color.Green,
                    offset = Offset(0f, -2f),
                    blurRadius = 2f
                )
            )
        ){
            append(subtext)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = subAnnotatedString)
        Text(text = superAnnotatedString)
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun BrushForText(){
    val gradientsColors = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Yellow,
        Color.Magenta,
        Color.Gray,
        Color.Black,
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
        .padding(5.dp),
        contentAlignment = Alignment.Center){
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.text),
                fontSize = 30.sp,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = gradientsColors,
                    )
                ),
            )
        }


}


@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LearnCanvaTheme {
        Greeting3("Android")
    }
}