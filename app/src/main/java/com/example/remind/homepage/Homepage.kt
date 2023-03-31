package com.example.remind.homepage

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl.animateItemPlacement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomepageScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.Neutral50)
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_2),
                            contentDescription = "Logo App",
                            modifier = Modifier
                                .size(width = 119.dp, height = 24.dp)
                        )
                        
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_notifikasi),
                                contentDescription = "Icon Notifikasi",
                                modifier = Modifier
                                    .size(19.2.dp)
                                    .weight(1f)
                            )
                        }
                    }
                }
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .padding(bottom = 30.dp)
                        .height(55.dp)
                        .clip(RoundedCornerShape(10.dp))
                ) {
                    BottomNavigation(
                        modifier = Modifier
                            .align(Alignment.Center),
                        backgroundColor = Colors.Primary500,
                        elevation = 0.dp,
                        contentColor = Color.White
                    ) {
                        BottomNavigationItem(
                            icon = Icon(
                                painter = painterResource(id = R.drawable.home_btn),
                                contentDescription = "Home Button",
                                modifier = Modifier
                                    .size(18.dp)
                                    .alpha(
                                        when()
                                    )
                            )
                            selected = ,
                            onClick = { /*TODO*/ }
                        ) {

                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            },
            backgroundColor = Color.Transparent
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 28.dp, top = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profil_image),
                        contentDescription = "Foto Profil",
                        modifier = Modifier
                            .size(60.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(top = 12.5.dp, bottom = 12.5.dp, start = 15.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Hi, Jessica",
                            color = Colors.Shades300,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )

                        Text(
                            text = "Selamat pagi !",
                            color = Colors.Shades300,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    }
                }
                Text(
                    text = "Tugas",
                    style = Typography.h5_semibold,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 23.dp, end = 23.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(123.dp)
                            .background(
                                color = Colors.Primary500,
                                RoundedCornerShape(11.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                            ) {
                                Text(
                                    text = "Selesaikan",
                                    modifier = Modifier
                                        .padding(top = 21.dp, start = 27.86.dp),
                                    style = Typography.body14_regular,
                                    color = Colors.Neutral50
                                )
                                Text(
                                    text = "10",
                                    modifier = Modifier
                                        .padding(start = 22.65.dp, top = 34.dp)
                                        .size(width = 58.94.dp, height = 64.dp),
                                    style = Typography.h1_bold,
                                    color = Colors.Neutral50
                                )
                                Text(
                                    text = "Tugas Hari Ini",
                                    modifier = Modifier
                                        .padding(top = 93.dp, start = 27.86.dp),
                                    style = Typography.body14_regular,
                                    color = Colors.Neutral50
                                )
                            }

                            Image(
                                painter = painterResource(id = R.drawable.icon_orang),
                                contentDescription = "Icon Orang",
                                modifier = Modifier
                                    .size(width = 101.dp, height = 131.dp)
                                    .padding(top = 10.dp, start = 47.4.dp)
                                    .weight(1f)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .size(width = 150.03.dp, height = 122.dp)
                                .padding(top = 17.dp)
                                .weight(1f)
                                .background(
                                    color = Colors.Primary300,
                                    RoundedCornerShape(11.dp)
                                )
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Text(
                                    text = "10",
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 24.65.dp)
                                        .size(height = 41.dp, width = 37.51.dp),
                                    style = Typography.h3_semibold,
                                    color = Colors.Neutral50
                                )
                                Text(
                                    text = "Berlangsung",
                                    modifier = Modifier
                                        .padding(top = 1.dp, start = 16.08.dp),
                                    style = Typography.body10_regular,
                                    color = Colors.Neutral50
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.width(13.93.dp))

                        Box(
                            modifier = Modifier
                                .size(width = 150.03.dp, height = 122.dp)
                                .padding(top = 17.dp)
                                .weight(1f)
                                .background(
                                    color = Colors.Primary50,
                                    RoundedCornerShape(11.dp)
                                )
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Text(
                                    text = "10",
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 24.65.dp)
                                        .size(height = 41.dp, width = 37.51.dp),
                                    style = Typography.h3_semibold,
                                    color = Colors.Shades300
                                )
                                Text(
                                    text = "Berlangsung",
                                    modifier = Modifier
                                        .padding(top = 1.dp, start = 16.08.dp),
                                    style = Typography.body10_regular,
                                    color = Colors.Shades300
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
//
//@Preview(showSystemUi = true)
//@Composable
//fun HomepagePreview(){
//    HomepageScreen()
//}
