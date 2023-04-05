package com.example.remind.homepage

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.rotary.onPreRotaryScrollEvent
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

@ExperimentalMaterialApi
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

                Text(
                    text = "Aktivitas",
                    style = Typography.h5_semibold,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                ExpandableCard(
                    title = "Brainstorming",
                    detail = "Morem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vulputate" +
                            " libero et velit interdum, ac aliquet odio mattis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur tempus urna at turpis condimentum lobortis. Ut commodo efficitur neque. Ut diam quam, semper iaculis condimentum ac, vestibulum eu nisl.\n" +
                            "\n" +
                            " conubia nostra, per inceptos himenaeos. Curabitur tempus urna at turpis condimentum lobortis. Ut commodo efficitur neque. Ut diam quam",
                    description = "PM diminta untuk membuat wireframe dari aplikasi yang sudah didesain sebelumnya"
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title : String,
    description : String,
    detail : String
){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 20.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .animateContentSize(
                    animationSpec = tween(
                        delayMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            backgroundColor = Colors.Secondary500,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Row(
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                        .background(color = Colors.Neutral50)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 25.dp, end = 35.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Text(
                            text = "Berlangsung",
                            modifier = Modifier
                                .background(color = Colors.Secondary500, RoundedCornerShape(20.dp))
                                .padding(horizontal = 15.dp, vertical = 5.dp),
                            style = Typography.body10_regular,
                            color = Colors.Shades300
                        )
                    }

                    Text(
                        text = title,
                        style = Typography.body14_semibold,
                        modifier = Modifier
                            .padding(start = 20.dp, 10.dp)
                    )

                    if (expandedState){
                        Column() {
                            Text(
                                text = detail,
                                style = Typography.body12_regular,
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 26.dp)
                            )

                            Box(
                                modifier = Modifier
                                    .padding(top = 14.dp, start = 20.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Mark as done",
                                    modifier = Modifier
                                        .background(
                                            color = Colors.Warning300,
                                            RoundedCornerShape(20.dp)
                                        )
                                        .padding(horizontal = 16.5.dp, vertical = 5.dp),
                                    style = Typography.body10_regular,
                                    color = Colors.Shades300
                                )
                            }
                        }
                    }
                    else {
                        Text(
                            text = description,
                            style = Typography.body12_regular,
                            modifier = Modifier
                                .padding(start = 20.dp, bottom = 10.dp, end = 49.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .height(44.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_alarm),
                                contentDescription = "Icon Alarm",
                                modifier = Modifier
                                    .size(24.dp)
                            )

                            Text(
                                text = "22 Maret 2023",
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                style = Typography.body12_regular,
                                color = Colors.Neutral800
                            )
                        }

                        IconButton(
                            onClick = {expandedState = !expandedState},
                            modifier = Modifier
                                .rotate(rotationState)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dropdown),
                                contentDescription = "Icon Dropdown",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .animateContentSize(
                    animationSpec = tween(
                        delayMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            backgroundColor = Colors.Success500,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Row(
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                        .background(color = Colors.Neutral50)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 25.dp, end = 35.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Text(
                            text = "Selesai",
                            modifier = Modifier
                                .background(color = Colors.Success500, RoundedCornerShape(20.dp))
                                .padding(horizontal = 15.dp, vertical = 5.dp),
                            style = Typography.body10_regular,
                            color = Colors.Shades300
                        )
                    }

                    Text(
                        text = title,
                        style = Typography.body14_semibold,
                        modifier = Modifier
                            .padding(start = 20.dp, 10.dp)
                    )

                    if (expandedState){
                        Column() {
                            Text(
                                text = detail,
                                style = Typography.body12_regular,
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 26.dp)
                            )

                            Box(
                                modifier = Modifier
                                    .padding(top = 14.dp, start = 20.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .background(
                                            color = Colors.Error500,
                                            RoundedCornerShape(20.dp)
                                        )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_delete),
                                        contentDescription = "Icon Delete",
                                        modifier = Modifier
                                            .padding(start = 26.dp)
                                            .padding(vertical = 5.dp)
                                            .size(12.dp)
                                    )
                                    Text(
                                        text = "Delete",
                                        modifier = Modifier
                                            .padding(start = 5.dp, end = 26.dp)
                                            .padding(vertical = 5.dp),
                                        style = Typography.body10_regular,
                                        color = Colors.Shades300
                                    )
                                }

                            }
                        }
                    }
                    else {
                        Text(
                            text = description,
                            style = Typography.body12_regular,
                            modifier = Modifier
                                .padding(start = 20.dp, bottom = 10.dp, end = 49.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .height(44.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_alarm),
                                contentDescription = "Icon Alarm",
                                modifier = Modifier
                                    .size(24.dp)
                            )

                            Text(
                                text = "22 Maret 2023",
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                style = Typography.body12_regular,
                                color = Colors.Neutral800
                            )
                        }

                        IconButton(
                            onClick = {expandedState = !expandedState},
                            modifier = Modifier
                                .rotate(rotationState)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dropdown),
                                contentDescription = "Icon Dropdown",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .animateContentSize(
                    animationSpec = tween(
                        delayMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            backgroundColor = Colors.Error500,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                expandedState = !expandedState
            }
        ) {
            Row(
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                        .background(color = Colors.Neutral50)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 25.dp, end = 35.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Text(
                            text = "Terlambat",
                            modifier = Modifier
                                .background(color = Colors.Error500, RoundedCornerShape(20.dp))
                                .padding(horizontal = 15.dp, vertical = 5.dp),
                            style = Typography.body10_regular,
                            color = Colors.Shades300
                        )
                    }

                    Text(
                        text = title,
                        style = Typography.body14_semibold,
                        modifier = Modifier
                            .padding(start = 20.dp, 10.dp)
                    )

                    if (expandedState){
                        Column() {
                            Text(
                                text = detail,
                                style = Typography.body12_regular,
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 26.dp)
                            )

                            Box(
                                modifier = Modifier
                                    .padding(top = 14.dp, start = 20.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier
                                        .background(
                                            color = Colors.Error500,
                                            RoundedCornerShape(20.dp)
                                        )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_delete),
                                        contentDescription = "Icon Delete",
                                        modifier = Modifier
                                            .padding(start = 26.dp)
                                            .padding(vertical = 5.dp)
                                            .size(12.dp)
                                    )
                                    Text(
                                        text = "Delete",
                                        modifier = Modifier
                                            .padding(start = 5.dp, end = 26.dp)
                                            .padding(vertical = 5.dp),
                                        style = Typography.body10_regular,
                                        color = Colors.Shades300
                                    )
                                }

                            }
                        }
                    }
                    else {
                        Text(
                            text = description,
                            style = Typography.body12_regular,
                            modifier = Modifier
                                .padding(start = 20.dp, bottom = 10.dp, end = 49.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .height(44.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_alarm),
                                contentDescription = "Icon Alarm",
                                modifier = Modifier
                                    .size(24.dp)
                            )

                            Text(
                                text = "22 Maret 2023",
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                style = Typography.body12_regular,
                                color = Colors.Neutral800
                            )
                        }

                        IconButton(
                            onClick = {expandedState = !expandedState},
                            modifier = Modifier
                                .rotate(rotationState)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dropdown),
                                contentDescription = "Icon Dropdown",
                                modifier = Modifier
                                    .size(24.dp)
                            )
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
