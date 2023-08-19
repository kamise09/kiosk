package com.example.compose_lab

import android.media.Image
import android.nfc.cardemulation.CardEmulation
import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_lab.ui.theme.Compose_labTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scrollState = rememberScrollState()
            val MenuName = arrayOf<String>(//메뉴이름 저장 - 메뉴 리스트
                "성보고1등 원재 뇌",
                "원재의 오른팔",
                "원재의 왼팔",
                "원재의 오른손 중지",
                "원재의 왼손 약지",
                "원재의 오른다리",
                "원재의 왼다리",
                "원재의 엄지발가락",
                "원재의 새끼발가락",
                "원재의 뜨거운 심장"
            )
            val MenuCost = arrayOf<Int>(//메뉴 가격 저장
                25000,
                35000,
                40000,
                50000,
                75000,
                45000,
                12000,
                13000,
                24000,
                54000
            )
            val MenuImage = arrayOf<Int>(//메뉴 해당 이미지저장
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae,
                R.drawable.wonjae
            )
            Column(){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(Color.Black)
                        .padding(20.dp),
                    contentAlignment = Alignment.TopCenter,
                ){
                    Text(text = "Wonjae's Pick",
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
                    for(i in 0..9){
                        MenuCard(name = MenuName[i],
                                cost = MenuCost[i],
                                menuimage = MenuImage[i])
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
                        Column(

                        ){
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
                .background(Color.Magenta)
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
                            .background(Color.Cyan),
                    ){
                        Text(text = name,
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                                .background(Color.Green)
                        )
                        Text(text = "${cost}원",
                            fontSize = 40.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .background(Color.Green)
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