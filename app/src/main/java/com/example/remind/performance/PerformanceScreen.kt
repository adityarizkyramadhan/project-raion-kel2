package com.example.remind.performance

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.ui.geometry.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import com.example.remind.ui.theme.Colors
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.remind.R
import com.example.remind.homepage.BottomNavBar
import com.example.remind.ui.theme.Typography
import com.maxkeppeker.sheets.core.models.base.SheetState

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PerformanceScreen(navController: NavController){
        Scaffold(
            bottomBar = {
                BottomNavBar(navController)
            }
        ){
            val sheetState = rememberBottomSheetState(
                initialValue = BottomSheetValue.Collapsed
            )
            val scaffoldState = rememberBottomSheetScaffoldState(
                bottomSheetState = sheetState
            )

            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 25.dp)
                            .fillMaxWidth()
                            .height(697.dp)
                            .background(
                                color = Colors.Neutral50,
                                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                            )
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 28.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 18.dp, bottom = 22.dp)
                                    .size(width = 57.dp, height = 4.dp)
                                    .background(
                                        color = Colors.Primary900,
                                        shape = RoundedCornerShape(50.dp)
                                    )
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Colors.Primary50, Colors.Primary500)
                                        ),
                                        shape = RoundedCornerShape(15.dp)
                                    )
                            ){
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                ) {
                                    Text(
                                        text = "Progress Anda",
                                        style = Typography.body14_semibold,
                                        color = Colors.Primary900,
                                        modifier = Modifier
                                            .padding(top = 22.dp, start = 23.dp)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.progress_anda),
                                        contentDescription = "Progress anda",
                                        modifier = Modifier
                                            .size(width = 142.dp, height = 243.54.dp)
                                            .padding(start = 34.dp, end = 11.dp)
                                            .weight(1f)
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(top = 44.dp)
                                    .fillMaxWidth()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(
                                            brush = Brush.linearGradient(
                                                colors = listOf(Colors.Primary50, Colors.Primary300)
                                            ),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .height(103.dp)
                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 20.dp, end = 11.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(width = 4.dp, height = 67.dp)
                                                .background(
                                                    color = Colors.Primary500,
                                                    shape = RoundedCornerShape(25.dp)
                                                )
                                        )

                                        Column(
                                            modifier = Modifier
                                                .padding(start = 9.dp)
                                        ) {
                                            Text(
                                                text = "Brainstorming",
                                                style = Typography.body12_semibold,
                                                color = Colors.Primary500
                                            )

                                            LinearProgressIndicator(
                                                modifier = Modifier
                                                    .padding(top = 12.dp)
                                                    .fillMaxWidth()
                                                    .height(22.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                backgroundColor = Colors.Primary50,
                                                color = Colors.Primary300,
                                                progress = 0.4f
                                            )
                                        }
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .padding(top = 22.dp)
                                        .fillMaxWidth()
                                        .background(
                                            brush = Brush.linearGradient(
                                                colors = listOf(Colors.Primary50, Colors.Primary300)
                                            ),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .height(103.dp)
                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 20.dp, end = 11.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(width = 4.dp, height = 67.dp)
                                                .background(
                                                    color = Colors.Primary500,
                                                    shape = RoundedCornerShape(25.dp)
                                                )
                                        )

                                        Column(
                                            modifier = Modifier
                                                .padding(start = 9.dp)
                                        ) {
                                            Text(
                                                text = "Brainstorming",
                                                style = Typography.body12_semibold,
                                                color = Colors.Primary500
                                            )

                                            LinearProgressIndicator(
                                                modifier = Modifier
                                                    .padding(top = 12.dp)
                                                    .fillMaxWidth()
                                                    .height(22.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                backgroundColor = Colors.Primary50,
                                                color = Colors.Primary300,
                                                progress = 0.4f
                                            )
                                        }
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .padding(top = 22.dp)
                                        .fillMaxWidth()
                                        .background(
                                            brush = Brush.linearGradient(
                                                colors = listOf(Colors.Primary50, Colors.Primary300)
                                            ),
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .height(103.dp)
                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 20.dp, end = 11.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(width = 4.dp, height = 67.dp)
                                                .background(
                                                    color = Colors.Primary500,
                                                    shape = RoundedCornerShape(25.dp)
                                                )
                                        )

                                        Column(
                                            modifier = Modifier
                                                .padding(start = 9.dp)
                                        ) {
                                            Text(
                                                text = "Brainstorming",
                                                style = Typography.body12_semibold,
                                                color = Colors.Primary500
                                            )

                                            LinearProgressIndicator(
                                                modifier = Modifier
                                                    .padding(top = 12.dp)
                                                    .fillMaxWidth()
                                                    .height(22.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                backgroundColor = Colors.Primary50,
                                                color = Colors.Primary300,
                                                progress = 0.4f
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                sheetBackgroundColor = Colors.Neutral50,
                sheetShape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                sheetPeekHeight = 150.dp
            ) {
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
                    ){
                        val value by remember { mutableStateOf(80) }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(26.dp))
                            CircleProgressBar(
                                indicatorValue = value
                            )
                        }
                    }
                }
            }
        }
}

@Composable
fun CircleProgressBar(
    canvasSize : Dp = 304.dp,
    indicatorValue : Int = 0,
    maxIndicatorValue : Int = 100,
    backgroundIndicatorColor : Color = Color(0xFFDFD6F9).copy(alpha = 1f),
    backgroundIndicatorStrokeWidth : Float = 60f,
    foregroundIndicatorColor : Color = Colors.Primary900,
    foregroundIndicatorStrokeWidth : Float = 60f,
    bigTextFontSize: TextUnit = 83.sp,
    bigTextColor : Color = Colors.Primary900
){
    val animatedIndicatorValue = remember {
        Animatable(initialValue = 0f)
    }
    LaunchedEffect(key1 = indicatorValue){
        animatedIndicatorValue.animateTo(indicatorValue.toFloat())
    }

    val percentage = (-(animatedIndicatorValue.value / maxIndicatorValue) * 100)
    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    Column(
        modifier = Modifier
            .size(canvasSize)
            .background(
                color = Color(0xFFF3F1FF),
                shape = RoundedCornerShape(35.dp)
            )
            .drawBehind {
                val componentSize = size / 1.35f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmbeddedElements(
            bigText = indicatorValue.toString(),
            bigTextFontSize = bigTextFontSize,
            bigTextColor = bigTextColor
        )
    }
}

fun DrawScope.backgroundIndicator(
    componentSize : Size,
    indicatorColor : Color,
    indicatorStrokeWidth : Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = -360f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle : Float,
    componentSize : Size,
    indicatorColor : Color,
    indicatorStrokeWidth : Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

@Composable
fun EmbeddedElements(
    bigText : String,
    bigTextFontSize : TextUnit,
    bigTextColor : Color
){
    Text(
        text = bigText,
        color = bigTextColor,
        fontSize = bigTextFontSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@ExperimentalMaterialApi
@Composable
fun SwipeableContainer(){

}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun CircleBarPrev(){
    PerformanceScreen(navController = rememberNavController())
}