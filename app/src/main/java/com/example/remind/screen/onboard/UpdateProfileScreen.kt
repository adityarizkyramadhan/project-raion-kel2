package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.task.CustomAlert
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UpdateProfileScreen(navController: NavController) {
    var showAlert by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(Colors.Primary500, Colors.Neutral0),
                startY = 0.7f,
                endY = Float.POSITIVE_INFINITY
            )
        )
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White,
                    elevation = 0.dp
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { navController.navigate("homepage") }
                        ) {
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
                        IconButton(
                            onClick = {showAlert = true},
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.centang_button),
                                contentDescription = "ApproveButton",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            },
            backgroundColor = Color.Transparent,
        ) {
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
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.offset(y= (-50).dp).fillMaxWidth()
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
                            .padding(start = 30.dp, end = 30.dp, top = 70.dp)
                    ) {
                        Text(
                            text = "Nama",
                            style = Typography.body14_regular,
                            color = Colors.Shades300
                        )

                        var namavalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = namavalue,
                            onValueChange = { namavalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                        .padding(top = 13.dp)
                                        .fillMaxWidth()
                                        .height(51.dp)
                                        .background(
                                            Colors.Neutral100,
                                            RoundedCornerShape(13.dp)
                                        )
                                        .padding(start = 17.dp, top = 17.dp),
                                ) {
                                    if (namavalue.isEmpty()) {
                                        Text(
                                            text = "Jessica Dunn",
                                            color = Colors.Shades300,
                                            style = Typography.body12_regular,
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )

                        Text(
                            text = "Email",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        var emailvalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = emailvalue,
                            onValueChange = { emailvalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                        .padding(top = 13.dp)
                                        .fillMaxWidth()
                                        .height(51.dp)
                                        .background(
                                            Colors.Neutral100,
                                            RoundedCornerShape(13.dp)
                                        )
                                        .padding(start = 17.dp, top = 17.dp),
                                ) {
                                    if (emailvalue.isEmpty()) {
                                        Text(
                                            text = "jessica.dunn@email.com",
                                            color = Colors.Shades300,
                                            style = Typography.body12_regular,
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )

                        Text(
                            text = "Tanggal Lahir",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        var birthDayvalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = birthDayvalue,
                            onValueChange = { birthDayvalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                        .padding(top = 13.dp)
                                        .fillMaxWidth()
                                        .height(51.dp)
                                        .background(
                                            Colors.Neutral100,
                                            RoundedCornerShape(13.dp)
                                        )
                                        .padding(start = 17.dp, top = 17.dp),
                                ) {
                                    if (birthDayvalue.isEmpty()) {
                                        Text(
                                            text = "22 Maret 1997",
                                            color = Colors.Shades300,
                                            style = Typography.body12_regular,
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                        if (showAlert){
                            CustomAlert(
                                onDismiss = {showAlert = false}
                            )
                        }


                    }
                }
            }
        }
    }
}