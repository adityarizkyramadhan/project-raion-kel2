package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remind.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import com.example.remind.ui.theme.Typography
import com.example.remind.ui.theme.Colors
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(){
    Box(modifier = Modifier.background(brush = Brush.verticalGradient(
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
                            onClick = { /*TODO*/ }
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.back_btn),
                                contentDescription = "BackButton",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.logo_1),
                            contentDescription = "LogoTopBar",
                            modifier = Modifier.size(width = 119.dp, height = 24.dp)
                        )
                    }
                }
            },
            backgroundColor = Color.Transparent
        ){
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                val (amico) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.amico),
                    contentDescription = "Amico",
                    modifier = Modifier
                        .constrainAs(amico){
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .size(140.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPrev(){
    RegisterScreen()
}