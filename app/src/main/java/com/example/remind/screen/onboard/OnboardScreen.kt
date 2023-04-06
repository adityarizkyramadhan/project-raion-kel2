package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OnBoardScreen(navController: NavController){
    Box(modifier = Modifier.background(brush = Brush.verticalGradient(
        colors = listOf(Colors.Primary500, Colors.Neutral0),
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    ))){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_1),
                contentDescription = "Logo App",
                modifier = Modifier
                    .padding(top = 108.dp)
                    .size(width = 272.92.dp, height = 72.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.amico),
                contentDescription = "Amico",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(width = 295.dp, height = 290.dp)
            )

            Button(onClick = {
            navController.navigate("register")
            },
                shape = RoundedCornerShape(13.dp),
                modifier = Modifier
                    .padding(top = 130.dp)
                    .height(60.dp)
                    .width(300.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Primary500)
            ) {
                Text(text = "Daftar", style = Typography.h6_bold, color = Colors.Neutral50)
            }

            Row(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Sudah punya akun? ",
                    style = Typography.body14_regular
                )
                Text(
                    text = "Masuk",
                    style = Typography.body14_semibold,
                    textDecoration = TextDecoration.Underline,
                    color = Colors.Secondary900,
                    modifier = Modifier.clickable {
                    navController.navigate("login")
                    }
                )
            }
        }
    }
}