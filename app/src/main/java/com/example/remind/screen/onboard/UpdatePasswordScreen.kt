package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.task.CustomAlert
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UpdatePasswordScreen(navController: NavController) {
    var context = LocalContext.current
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
                        Text(text = "Password Lama",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        var passwdLamavalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = passwdLamavalue,
                            onValueChange = { passwdLamavalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            decorationBox = {innerTextField ->
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
                                ){
                                    if (passwdLamavalue.isEmpty()){
                                        Text(
                                            text = "yourPassword",
                                            color = Colors.Shades300,
                                            fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                        Text(text = "Password",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        var passwdvalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = passwdvalue,
                            onValueChange = { passwdvalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            decorationBox = {innerTextField ->
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
                                ){
                                    if (passwdvalue.isEmpty()){
                                        Text(
                                            text = "yourPassword",
                                            color = Colors.Shades300,
                                            fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )

                        Text(text = "Konfirmasi Password",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        var passwdconfirmvalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = passwdconfirmvalue,
                            onValueChange = { passwdconfirmvalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            decorationBox = {innerTextField ->
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
                                ){
                                    if (passwdconfirmvalue.isEmpty()){
                                        Text(
                                            text = "yourPasswordAgain",
                                            color = Colors.Shades300,
                                            fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                        if (showAlert){
                            if (passwdvalue != passwdconfirmvalue){
                                Toast.makeText(context, "Password baru tidak sama", Toast.LENGTH_LONG).show()
                            } else if (!passwdvalue.isEmpty() && !passwdconfirmvalue.isEmpty() && !passwdLamavalue.isEmpty()){
                                CustomAlertPassword(
                                    onDismiss = {showAlert = false},
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomAlertPassword(
    onDismiss: () -> Unit,
    navController: NavController,
    properties: DialogProperties = DialogProperties()
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = properties
    ) {
        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Colors.Neutral50
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(102.dp)
                        .background(
                            color = Colors.Success700,
                            shape = RoundedCornerShape(100.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.centang_button),
                        contentDescription = "Ceklis",
                        modifier = Modifier
                            .size(width = 33.33.dp, height = 22.92.dp)
                            .align(Alignment.Center)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 39.dp, end = 39.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "BERHASIL!",
                        style = Typography.h6_bold,
                        color = Colors.Shades300,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Passwordmu telah berhasil dirubah",
                        style = Typography.body12_regular,
                        color = Colors.Neutral900,
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("profile")
                    },
                    modifier = Modifier
                        .padding(top = 20.dp, start = 76.dp, end = 76.dp)
                        .height(34.dp)
                        .border(
                            width = 1.dp,
                            color = Colors.Primary500,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Neutral50)
                ) {
                    Text(
                        text = "Kembali ke Halaman Profil",
                        style = Typography.body12_regular,
                        color = Colors.Primary500,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
