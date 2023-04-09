package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.homepage.BottomNavBar
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NotifikasiScreen(navController: NavController){
    Box(modifier = Modifier.background(brush = Brush.verticalGradient(
        colors = listOf(Colors.Neutral0,Colors.Neutral0,Colors.Neutral0),
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    ))) {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    elevation = 0.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { navController.navigate("homepage") }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_left),
                                contentDescription = "BackButton",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Text(
                            text = "Notifikasi",
                            style = Typography.h6_bold,
                            modifier = Modifier
                                .weight(1f),
                            textAlign = TextAlign.Center,
                            color = Colors.Shades300
                        )
                    }
                }
            },
            backgroundColor = Color.Transparent,
        ){

            Column(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(25) {
                    Box(
                        modifier = Modifier
                            .background(color = Color(0xFFF6F6F6), shape = RoundedCornerShape(30.dp))
                            .padding(start = 18.dp, end=18.dp, top = 10.dp, bottom = 10.dp)
                            .size(width = 323.dp, height = 60.dp)
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.notif_icon),
                                contentDescription = "notif icon",
                                modifier = Modifier.size(31.dp)
                            )
                            Text(
                                text = "Tugas \"Membuat Wireframe\" harus dikumpulkan minggu ini pada tanggal 22 Maret 2023",
                                modifier = Modifier.weight(1f).padding(5.dp),
                                maxLines = Int.MAX_VALUE,
                            )
                        }
                    }


                }
            }


        }
    }

}