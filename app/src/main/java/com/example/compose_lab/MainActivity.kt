package com.example.compose_lab

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scrollState = rememberScrollState()
            val menuName = arrayOf(//메뉴이름 저장 - 메뉴 리스트
                "에이드개",
                "아이스아메리카노",
                "라떼",
                "팥빙수",
                "티라미슈"
            )
            val menuCost = arrayOf(//메뉴 가격 저장
                1500,
                1000,
                2000,
                3000,
                2000
            )
            val menuImage = arrayOf(//메뉴 해당 이미지저장
                R.drawable.ade,
                R.drawable.ade,
                R.drawable.ade,
                R.drawable.ade,
                R.drawable.ade
            )
            Column{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Black)
                        .padding(20.dp),
                    contentAlignment = Alignment.TopCenter,
                ){
                    Text(text = "kiosk",
                        fontSize = 80.sp,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp)
                        .verticalScroll(scrollState)
                        .padding(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){
                    // 메뉴 리스트업 ----------------------------------
                    for(i in 0..4){
                        MenuCard(name = menuName[i],
                                cost = menuCost[i],
                                menuimage = menuImage[i])
                        Box(modifier = Modifier.height(20.dp)){}
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .height(250.dp),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        contentAlignment = Alignment.CenterEnd,
                    ){
                        Column{
                            InputNick()
                            Box(modifier = Modifier.height(20.dp)){}
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor  = Color.Black,
                                    contentColor = Color.White,
                                ),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Text(text = "주문",
                                    color = Color.White,
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxSize(),
                        contentAlignment = Alignment.TopStart
                    ){
                        Text(text = "임시\n test",
                            fontSize = 30.sp,
                            modifier = Modifier
                                .background(Color.Yellow)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuCard(name:String,cost:Int,menuimage:Int){
    Card(
        shape = RoundedCornerShape(40.dp),
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .shadow(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ){
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.Blue)
                ){
                    Image(
                        painter = painterResource(id = menuimage),
                        contentDescription = "menu",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .padding(10.dp)
                        )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                    ){
                        Text(text = name,
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                        )
                        Text(text = "${cost}원",
                            fontSize = 40.sp,
                            color = Color.Black,
                            modifier = Modifier
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.CenterEnd
            ){
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor  = Color.Black,
                        contentColor = Color.White,
                    ),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "+",
                            color = Color.White,
                            fontSize = 100.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputNick() {
    var nick by remember { mutableStateOf("") }
    OutlinedTextField(
        value = nick,
        onValueChange = { nick = it },
        label = { Text("Nick Name") },
        modifier = Modifier
            .width(200.dp)
    )
}