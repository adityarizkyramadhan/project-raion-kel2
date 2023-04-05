package com.example.remind.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography

@Composable
fun TaskScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.Neutral50)
    ){
        Box(
            modifier = Modifier
                .padding(top = 68.dp, start = 15.dp, end = 19.39.dp)
                .fillMaxWidth()
                .height(170.25.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Colors.Primary500, Colors.Primary50)
                    ),
                    RoundedCornerShape(10.dp)
                )
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "SELESAIKAN\n" + "TUGASMU!",
                    style = Typography.h5_bold,
                    color = Colors.Neutral50
                )

                Image(
                    painter = painterResource(id = R.drawable.cuate),
                    contentDescription = "Cuate",
                    modifier = Modifier
                        .size(width = 144.61.dp, height = 150.25.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TaskPreview(){
    TaskScreen()
}