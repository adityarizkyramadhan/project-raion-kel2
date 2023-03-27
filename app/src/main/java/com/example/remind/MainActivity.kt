package com.example.remind

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remind.ui.theme.Typography
import com.example.remind.ui.theme.Color
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradientBackground()
            OnBoardScreen()
        }
    }
}

@Composable
fun GradientBackground(){
    val colors = listOf(Color.Primary500, Color.Neutral0)
    val gradientbg = Brush.verticalGradient(
        colors = colors,
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = gradientbg))
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OnBoardScreen(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        val (logo_1, amico, registerbtn, masuktext) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.logo_1), contentDescription = "App Logo",
            modifier = Modifier
                .constrainAs(logo_1) {
                    top.linkTo(parent.top, margin = 108.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(amico.top, margin = 15.dp)
                }
                .size(width = 272.92.dp, height = 72.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.amico), contentDescription = "Amico",
            modifier = Modifier
                .constrainAs(amico) {
                    top.linkTo(logo_1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(registerbtn.top)
                }
                .size(width = 295.dp, height = 290.dp)
        )
        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(13),
            modifier = Modifier
                .constrainAs(registerbtn) {
                    top.linkTo(amico.bottom, margin = 130.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .height(60.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Primary500)
        ) {
            Text(text = "Daftar", style = Typography.h6_bold, color = Color.Neutral50)
        }
        Row(modifier = Modifier
            .constrainAs(masuktext) {
                top.linkTo(registerbtn.bottom, margin = 15.dp)
                start.linkTo(parent.start)
                end.linkTo((parent.end))
            }
            .fillMaxWidth(),
            Arrangement.SpaceAround) {
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
    GradientBackground()
    OnBoardScreen()
}
