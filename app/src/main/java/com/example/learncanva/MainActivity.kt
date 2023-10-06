package com.example.learncanva

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            KeyHoleEffect()
           MyButton(onClick = {  }, content = { /*TODO*/ })
        }
    }
}


@Composable
fun DrawScope.backgroundIndicator() {
    Canvas(modifier = Modifier
        .fillMaxWidth(.5f)
        .fillMaxHeight(.4f)
        .padding(5.dp)
    ) {
        drawArc(
            color = Color.Blue,
            startAngle = 150f,
            sweepAngle = 240f,
            useCenter = false,
            style = Stroke(
                width = 10.dp.toPx(),
                cap = StrokeCap.Round
            ),
            topLeft = Offset(
                x = (size.width - 50f) / 2f,
                y = (size.height - 50f) / 2f
            ),
        )
    }
}

@Composable
@Preview
fun PreviewDrawingCanvas() {
    Column(modifier = Modifier
        .size(300.dp)
        .drawBehind {
        }) {

    }
}

@Composable
fun KeyHoleEffect(){
    var pointerOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }
    Log.d("TAG1", pointerOffset.toString())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput("dragging") {
                detectDragGestures { change, dragAmount ->
                    pointerOffset += dragAmount

                }
            }
            .onSizeChanged { size ->
                pointerOffset = Offset(size.width / 2f, size.height / 2f)
                Log.d("TAG", pointerOffset.toString())
            }
            .drawWithContent {
                drawContent()
                drawRect(
                    Brush.radialGradient(
                        listOf(Color.Transparent, Color.Black),
                        center = pointerOffset,
                        radius = 100.dp.toPx()
                    )
                )
            }
    ) {

        Text(
            modifier = Modifier.size(100.dp),
            text = "Hello World!"
        )

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
    }
}

@Composable
fun MyButton(
    onClick : () -> Unit,
    content : @Composable () -> Unit,
    borderColor: Color = Color.Black,
    borderWidth: Dp = 5.dp,
) {
    Canvas(modifier = Modifier
        .size(100.dp, 50.dp)
        .drawWithContent {
            drawContent()
            drawRect(borderColor, style = Stroke(width = borderWidth.toPx()))
        }
    ) {
        content
    }
}

