package com.example.remind.task

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.remind.R
import com.example.remind.ui.theme.Colors
import com.example.remind.ui.theme.Typography
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddTaskScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.Primary500)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp,
                    contentColor = Color.White,
                    modifier = Modifier
                        .padding(start = 21.dp, end = 23.dp)
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.back_btn),
                                contentDescription = "Back Button",
                                modifier = Modifier
                                    .size(24.dp)
                                    .weight(1f)
                            )
                        }

                        Text(
                            text = "Buat Tugas",
                            style = Typography.h6_bold,
                            modifier = Modifier
                                .weight(1f),
                            textAlign = TextAlign.Center,
                            color = Colors.Neutral50
                        )
                    }
                }
            },
            backgroundColor = Color.Transparent
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(
                            color = Colors.Neutral50,
                            RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 30.dp, end = 30.dp, top = 40.dp, bottom = 26.dp)
                    ) {
                        Column(
                        ) {
                            Text(
                                text = "Nama Tugas",
                                style = Typography.body14_semibold,
                                color = Color(0xFF000000)
                            )

                            var valueTask by remember { mutableStateOf("") }
                            BasicTextField(
                                value = valueTask,
                                onValueChange = { valueTask = it },
                                maxLines = 1,
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Text
                                ),
                                textStyle = TextStyle(
                                    color = Colors.Shades300,
                                    fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                decorationBox = {innerTextField ->
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 5.dp)
                                            .fillMaxWidth()
                                            .height(44.dp)
                                            .background(
                                                Colors.Neutral100,
                                                RoundedCornerShape(5.dp)
                                            )
                                            .padding(start = 10.dp, top = 15.dp)
                                    ){
                                        if (valueTask.isEmpty()){
                                            Text(
                                                text = "Name of your task",
                                                color = Colors.Neutral900,
                                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Normal
                                            )
                                        }
                                        innerTextField()
                                    }
                                }
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(top = 20.dp)
                        ) {
                            Text(
                                text = "Deskripsi",
                                style = Typography.body14_semibold,
                                color = Color(0xFF000000)
                            )

                            var valueDesc by remember { mutableStateOf("") }
                            BasicTextField(
                                value = valueDesc,
                                onValueChange = { valueDesc = it },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Text
                                ),
                                textStyle = TextStyle(
                                    color = Colors.Shades300,
                                    fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                modifier = Modifier
                                    .height(100.dp),
                                decorationBox = {innerTextField ->
                                    Box(
                                        modifier = Modifier
                                            .padding(top = 5.dp)
                                            .fillMaxWidth()
                                            .height(44.dp)
                                            .background(
                                                Colors.Neutral100,
                                                RoundedCornerShape(5.dp)
                                            )
                                            .padding(start = 10.dp, top = 15.dp)
                                    ){
                                        if (valueDesc.isEmpty()){
                                            Text(
                                                text = "Description about your task...",
                                                color = Colors.Neutral900,
                                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Normal
                                            )
                                        }
                                        innerTextField()
                                    }
                                }
                            )
                        }
                        CalendarView()

                        var showAlert by remember {
                            mutableStateOf(false)
                        }

                        Button(
                            onClick = {showAlert = true},
                            modifier = Modifier
                                .padding(top = 155.dp)
                                .fillMaxWidth()
                                .height(52.dp),

                            colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Primary500),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Buat Tugas",
                                style = Typography.h6_semibold,
                                color = Colors.Neutral50
                            )
                        }

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

@Composable
fun CustomAlert(
    onDismiss: () -> Unit,
    properties: DialogProperties = DialogProperties()
){
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
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_success),
                    contentDescription = "Success"
                    modifier = Modifier
                        .size(102.dp)
                )

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
                        text = "Tugasmu sudah berhasil ditambahkan\n" +
                                "Cek tugasmu dengan klik tombol di bawah",
                        style = Typography.body12_regular,
                        color = Colors.Neutral900,
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = {onDismiss},
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
                        text = "Kembali ke Halaman Tugas",
                        style = Typography.body12_regular,
                        color = Colors.Primary500,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CalendarView(){
    val calendarState = rememberSheetState()

    CalendarDialog(state = calendarState, selection = CalendarSelection.Date {date ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("SelectedDate", "$date")
        }
    })

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
    ) {
        Text(
            text = "Tanggal & Waktu",
            style = Typography.body14_semibold,
            color = Color(0xFF000000)
        )

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Mulai",
                style = Typography.body14_regular,
                color = Colors.Shades300
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {calendarState.show()},
                    modifier = Modifier
                        .height(34.dp)
                        .border(
                            width = 1.dp,
                            color = Colors.Primary300,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Neutral50)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "",
                            modifier = Modifier
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                        Text(
                            text = "10 Maret 2023",
                            style = Typography.body12_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                    }
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(34.dp)
                        .padding(start = 20.dp)
                        .border(
                            width = 1.dp,
                            color = Colors.Primary300,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Neutral50)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = "",
                            modifier = Modifier
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                        Text(
                            text = "0:30 PM",
                            style = Typography.body12_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Selesai",
                style = Typography.body14_regular,
                color = Colors.Shades300
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {calendarState.show()},
                    modifier = Modifier
                        .height(34.dp)
                        .border(
                            width = 1.dp,
                            color = Colors.Primary300,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Neutral50)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "",
                            modifier = Modifier
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                        Text(
                            text = "10 Maret 2023",
                            style = Typography.body12_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                    }
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(34.dp)
                        .padding(start = 20.dp)
                        .border(
                            width = 1.dp,
                            color = Colors.Primary300,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Neutral50)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = "",
                            modifier = Modifier
                                .size(14.dp),
                            tint = Colors.Shades300
                        )
                        Text(
                            text = "0:30 PM",
                            style = Typography.body12_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.N)
//@Preview(showSystemUi = true)
//@Composable
//fun AddTaskPreview(){
//    AddTaskScreen()
//}