package com.example.remind.performance

import android.annotation.SuppressLint
import androidx.compose.ui.geometry.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import com.example.remind.ui.theme.Colors
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.remind.R
import com.example.remind.homepage.BottomNavBar
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PerformanceScreen(navController: NavController){
    Box(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(
        colors = listOf(Colors.Primary500, Colors.Neutral0),
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    ))){
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White,
                    elevation = 0.dp
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { navController.navigate("homepage") }
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.back_btn),
                                contentDescription = "BackButton",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Text(
                            text = "Performa",
                            style = Typography.h6_bold,
                            modifier = Modifier
                                .weight(1f),
                            textAlign = TextAlign.Center,
                            color = Colors.Neutral50
                        )
                    }
                }
            },
            backgroundColor = Color.Transparent,
            bottomBar = {
                BottomNavBar(navController)
            }
        ){

        }
    }
}

@Composable
fun CircleProgressBar(
    canvasSize : Dp = 304.dp,
    indicatorValue : Int = 0,
    maxIndicatorValue : Int = 100,
    backgroundIndicatorColor : Color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
    backgroundIndicatorStrokeWidth : Float = 100f
){
    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
            }
    ) {

    }
}

fun DrawScope.backgroundIndicator(
    componentSize : Size,
    indicatorColor : Color,
    indicatorStrokeWidth : Float
){
    drawArc(
        color = indicatorColor,
        startAngle = 180f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CircleBarPrev(){
    CircleProgressBar()
}