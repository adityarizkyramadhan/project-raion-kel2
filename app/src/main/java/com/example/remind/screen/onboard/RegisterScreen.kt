package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remind.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.remind.ui.theme.Typography
import com.example.remind.ui.theme.Colors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.coroutines.coroutineContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(navController: NavController){
    var isFormSubmitted by remember { mutableStateOf(false) }
    val context = LocalContext.current

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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.amico),
                    contentDescription = "Amico",
                    modifier = Modifier
                        .size(140.dp)
                )
                Box(
                    modifier = Modifier
                        .padding(top = 16.53.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                            color = Colors.Neutral50,
                            RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 32.dp, end = 32.dp, top = 32.dp)
                    ) {
                        Text(text = "Email",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                        )

                        var emailvalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = emailvalue,
                            onValueChange = { emailvalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email
                            ),
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
                                    if (emailvalue.isEmpty()){
                                        Text(
                                            text = "youremail@gmail.com",
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

                        Text(text = "Username",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )

                        var unamevalue by remember { mutableStateOf("") }
                        BasicTextField(
                            value = unamevalue,
                            onValueChange = { unamevalue = it },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Text
                            ),
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
                                    if (unamevalue.isEmpty()){
                                        Text(
                                            text = "yourUsername",
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

                        Button(
                            onClick = {
                                if (!emailvalue.isEmpty() && !unamevalue.isEmpty() && !passwdvalue.isEmpty() && !passwdconfirmvalue.isEmpty()){
                                    isFormSubmitted == true
                                    navController.navigate("login")
                                } else {
                                    Toast.makeText(context, "Maaf, Anda harus mengisi seluruh form yang disediakan", Toast.LENGTH_LONG).show()
                                }
                            },
                            shape = RoundedCornerShape(13.dp),
                            modifier = Modifier
                                .padding(top = 24.dp)
                                .fillMaxWidth()
                                .height(60.dp),
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
        }
    }
}
//
//@Preview(showSystemUi = true)
//@Composable
//fun RegisterPreview(){
//    RegisterScreen()
//}