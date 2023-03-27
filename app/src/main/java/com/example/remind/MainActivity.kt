package com.example.remind

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remind.ui.theme.Typography
import com.example.remind.ui.theme.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnBoardScreen()
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OnBoardScreen(){
    val colors = listOf(Color.Primary500, Color.Neutral0)
    val gradientbg = Brush.verticalGradient(
        colors = colors,
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = gradientbg))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_1), contentDescription = "App Logo",
            modifier = Modifier
                .size(width = 272.92.dp, height = 72.dp)
                .offset(y = 108.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.amico), contentDescription = "Amico",
            modifier = Modifier
                .size(width = 295.dp, height = 290.dp)
                .offset(y = 123.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            Button(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(13),
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp)
                    .offset(y = 203.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Primary500)
            ) {
                Text(text = "Daftar", style = Typography.h6_bold, color = Color.Neutral50)
            }
        }
        Row(modifier = Modifier.fillMaxWidth().offset(y = 218.dp), Arrangement.SpaceAround) {
            MyClickableText(onClick = {
                /* do something */
            })
        }
    }
}

@Composable
fun MyClickableText(onClick: () -> Unit) {
    val annotatedText = buildAnnotatedString {
        pushStyle(SpanStyle(color = Color.Shades300, fontFamily = FontFamily(Font(R.font.poppins_regular)), fontSize = 14.sp))
        append("Sudah punya akun? ")
        pushStyle(SpanStyle(color = Color.Secondary900, fontFamily = FontFamily(Font(R.font.poppins_semibold)), fontSize = 14.sp, textDecoration = TextDecoration.Underline))
        append("Masuk")
        pop()
    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations("url", offset, offset)
                .firstOrNull()?.let { annotation ->
                    onClick
                }
        },
        modifier = Modifier.clickable {  }
    )
}


@Preview (showSystemUi = true)
@Composable
fun PreviewMessageCard(){
    OnBoardScreen()
}
