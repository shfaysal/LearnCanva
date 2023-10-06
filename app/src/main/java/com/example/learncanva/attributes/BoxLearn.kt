package com.example.learncanva.attributes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncanva.attributes.ui.theme.LearnCanvaTheme

class BoxLearn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowRowExample()
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "hello"
        )
    }

}

@Composable
fun GreetingPreview() {
    LearnCanvaTheme {
        Greeting2("Android")
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowExample(){
    FlowRow(
        modifier = Modifier
            .fillMaxWidth(1f)
//            .fillMaxSize()
            .wrapContentHeight(align = Alignment.Top),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        maxItemsInEachRow = 5
    ) {
        repeat(16){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .absolutePadding(20.dp)
//                    .align(Alignment.CenterVertically)
                    .width(150.dp)
                    .height(150.dp)
                    .padding(3.dp)
                    .background(Color.Green)
                    .verticalScroll(rememberScrollState())
            ){
                Text(
                    text = "hello everybody dsfafdasfa dgsd dsgfsgs sdgfsgsdfgsdgf",
                    fontSize = 38.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextExample(){
    Text(
        text = "Hello",
        modifier = Modifier
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}
