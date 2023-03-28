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
import com.example.remind.ui.theme.Color
import com.example.remind.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OnBoardScreen(navController: NavController){
    Box(modifier = Modifier.background(brush = Brush.verticalGradient(
        colors = listOf(Color.Primary500, Color.Neutral0),
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    ))){
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
            Button(onClick = {
                             navController.navigate("register")
            },
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