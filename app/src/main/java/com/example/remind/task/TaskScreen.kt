package com.example.remind.task

import androidx.compose.animation.Animatable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Index
import com.example.remind.R
import com.example.remind.homepage.ExpandableCard
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun TaskScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.Neutral50)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 68.dp, start = 15.dp, end = 19.39.dp)
                    .fillMaxWidth()
                    .height(170.25.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Colors.Primary500, Colors.Primary50)
                        ),
                        RoundedCornerShape(10.dp)
                    )
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "SELESAIKAN\n" + "TUGASMU!",
                        style = Typography.h5_bold,
                        color = Colors.Neutral50
                    )

                    Image(
                        painter = painterResource(id = R.drawable.cuate),
                        contentDescription = "Cuate",
                        modifier = Modifier
                            .size(width = 144.61.dp, height = 150.25.dp)
                    )
                }
            }

            var value by remember { mutableStateOf("") }
            BasicTextField(
                value = value,
                onValueChange = { value = it },
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text
                ),
                textStyle = TextStyle(
                    color = Colors.Neutral700,
                    fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                ),
                decorationBox = {innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(top = 23.dp)
                            .padding(horizontal = 23.dp)
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Colors.Primary50,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .height(38.dp)
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            if (value.isEmpty()){
                                Text(
                                    text = "Cari Tugas",
                                    color = Colors.Neutral700,
                                    fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                )
                            }
                            innerTextField()

                            IconButton(
                                onClick = { /*TODO*/ }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Icon Search",
                                    modifier = Modifier
                                        .size(18.dp)
                                        .weight(1f)
                                )
                            }
                        }
                    }
                }
            )

            TabLayout()
        }
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun TabLayout(){
    var selectedTabIndex by remember { mutableStateOf(0) }
    
    Column(
        modifier = Modifier
            .padding(horizontal = 10.5.dp, vertical = 30.dp)
            .height(32.dp)
    ) {
        TabRow(
            selectedTabIndex,
            backgroundColor = Colors.Neutral50,
            indicator = { }
        ){
            Tab(
                text = {
                    Text(
                        text = "Semua",
                        color = if (selectedTabIndex == 0) Colors.Neutral50 else Colors.Shades300,
                        style = Typography.body10_regular
                    )
                },
                selected =  selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0},
                modifier = Modifier
                    .background(
                        if (selectedTabIndex == 0) Colors.Primary500 else Color.Transparent,
                        RoundedCornerShape(20.dp)
                    )
                    .weight(1f)
            )
            Tab(
                text = {
                    Text(
                        text = "Berlangsung",
                        color = if (selectedTabIndex == 1) Colors.Neutral50 else Colors.Shades300,
                        style = Typography.body10_regular
                    )
                },
                selected =  selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1},
                modifier = Modifier
                    .background(
                        if (selectedTabIndex == 1) Colors.Primary500 else Color.Transparent,
                        RoundedCornerShape(20.dp)
                    )
                    .weight(1f)
            )
            Tab(
                text = {
                    Text(
                        text = "Terlambat",
                        color = if (selectedTabIndex == 2) Colors.Neutral50 else Colors.Shades300,
                        style = Typography.body10_regular
                    )
                },
                selected =  selectedTabIndex == 2,
                onClick = { selectedTabIndex = 2},
                modifier = Modifier
                    .background(
                        if (selectedTabIndex == 2) Colors.Primary500 else Color.Transparent,
                        RoundedCornerShape(20.dp)
                    )
                    .weight(1f)
            )
            Tab(
                text = {
                    Text(
                        text = "Selesai",
                        color = if (selectedTabIndex == 3) Colors.Neutral50 else Colors.Shades300,
                        style = Typography.body10_regular
                    )
                },
                selected =  selectedTabIndex == 3,
                onClick = { selectedTabIndex = 3},
                modifier = Modifier
                    .background(
                        if (selectedTabIndex == 3) Colors.Primary500 else Color.Transparent,
                        RoundedCornerShape(20.dp)
                    )
                    .weight(1f)
            )
        }
        TabContent(tabIndex = selectedTabIndex)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TabContent(tabIndex: Int){
    when (tabIndex){
        0 -> {
            ExpandableCard(title = "Brainstorming", description = "11111", detail = "00000")
        }
        1 -> {
            ExpandableCard(title = "Desain", description = "11111", detail = "00000")
        }
        2 -> {
            ExpandableCard(title = "Develop", description = "11111", detail = "00000")
        }
        3 -> {
            ExpandableCard(title = "Deploy", description = "11111", detail = "00000")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TaskPreview(){
    TaskScreen()
}