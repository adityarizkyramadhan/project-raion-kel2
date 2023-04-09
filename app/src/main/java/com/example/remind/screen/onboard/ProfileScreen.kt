package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import android.widget.ImageButton
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.homepage.BottomNavBar
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavController){
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
                            onClick = { navController.navigate("homepage")}
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.back_btn),
                                contentDescription = "BackButton",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Text(
                            text = "Profil",
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 86.dp)
                        .fillMaxWidth()
                        .height(630.dp)
                        .background(
                            color = Colors.Neutral50,
                            RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                ){
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .offset(y = (-50).dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ellipse),
                            contentDescription = "foto profile",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 65.dp, start = 33.dp, end = 30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Jessica Dunn",
                            style = Typography.body14_bold,
                            color = Color(0xFF0F172A),
                        )
                        Text(
                            text = "jessica.dunn@email.com",
                            style = Typography.body10_regular,
                            color = Colors.Neutral900,
                        )
                        Column(
                            modifier = Modifier
                                .padding(top=60.dp)
                        ) {
                            Divider(
                                color = Color.Gray,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        vertical = 20.dp,
                                        horizontal = 10.dp
                                    )
                                    .clickable(
                                        onClick = {
                                            navController.navigate("updateprofile")
                                        }
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.change_profile_icon),
                                    contentDescription = "change profile",
                                    modifier = Modifier.size(28.dp)
                                )
                                Text(
                                    text = "Ubah Profil",
                                    modifier = Modifier.padding(start = 15.dp),
                                    style = Typography.body12_regular,
                                    color = Colors.Shades300,
                                )
                                Image(
                                    painter =  painterResource(id = R.drawable.arrow_up),
                                    contentDescription =  "ubah profile",
                                    modifier = Modifier
                                        .size(width = 7.dp, height = 3.38.dp)
                                        .padding(start = 160.25.dp)
                                )
                            }
                            Divider(
                                color = Color.Gray,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        vertical = 20.dp,
                                        horizontal = 10.dp
                                    )
                                    .clickable(
                                        onClick = {
                                            navController.navigate("updatepassword")
                                        }
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.change_password_icon),
                                    contentDescription = "change password",
                                    modifier = Modifier.size(28.dp)
                                )
                                Text(
                                    text = "Ubah Password",
                                    modifier = Modifier.padding(start = 15.dp),
                                    style = Typography.body12_regular,
                                    color = Colors.Shades300,
                                )
                                Image(
                                    painter =  painterResource(id = R.drawable.arrow_up),
                                    contentDescription =  "ubah password",
                                    modifier = Modifier
                                        .size(width = 7.dp, height = 3.38.dp)
                                        .padding(start = 132.25.dp)
                                )
                            }
                            Divider(
                                color = Color.Gray,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        vertical = 20.dp,
                                        horizontal = 10.dp
                                    )
                                    .clickable(
                                        onClick = {
                                            navController.navigate("onboard")
                                        }
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.logout_icon),
                                    contentDescription = "keluar",
                                    modifier = Modifier.size(28.dp)
                                )
                                Text(
                                    text = "Keluar",
                                    modifier = Modifier.padding(start = 15.dp),
                                    style = Typography.body12_regular,
                                    color = Colors.Shades300,
                                )
                                Image(
                                    painter =  painterResource(id = R.drawable.arrow_up),
                                    contentDescription =  "keluar",
                                    modifier = Modifier
                                        .size(width = 7.dp, height = 3.38.dp)
                                        .padding(start = 187.25.dp)
                                )
                            }
                            Divider(
                                color = Color.Gray,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }


        }
    }
}