package com.yongjincompany.attendence.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.yongjincompany.attendence.R
import com.yongjincompany.attendence.ui.theme.LightTextColor
import com.yongjincompany.attendence.ui.theme.NotoSans
import com.yongjincompany.attendence.ui.theme.PrimaryColor

@Composable
fun LoginScreen() {
    BackGroundImage()
    LoginArea()
}


@Composable
fun LoginArea() {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var isPasswordOpen by remember {
        mutableStateOf(false)
    }

    Box(contentAlignment = Alignment.BottomCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "DUBAS",
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                fontFamily = NotoSans,
                fontWeight = FontWeight.Bold)

            /*Button(onClick = {}) {
                Row() {
                    Icon(Icons)
                }
            }*/
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp), backgroundColor = Color.White,
                elevation = 0.dp, shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "당유백 출근을 환영합니다",
                        color = Color.Black,
                        fontFamily = NotoSans,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(top = 16.dp))

                    OutlinedTextField(value = email, onValueChange = { email = it },
                        label = {
                            Text(text = "이메일을 입력하세요", color = LightTextColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = PrimaryColor,
                            focusedBorderColor = PrimaryColor,
                            textColor = PrimaryColor
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(painter = painterResource(id = R.drawable.ic_email),
                                contentDescription = "",
                                tint = PrimaryColor,
                                modifier = Modifier.size(24.dp))
                        }
                    )


                    OutlinedTextField(value = password, onValueChange = { password = it },
                        label = {
                            Text(text = "비밀번호를 입력하세요", color = LightTextColor)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = PrimaryColor,
                            focusedBorderColor = PrimaryColor,
                            textColor = PrimaryColor
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(painter = painterResource(id = R.drawable.ic_password),
                                contentDescription = "",
                                tint = PrimaryColor,
                                modifier = Modifier.size(24.dp))
                        },
                        visualTransformation = if (!isPasswordOpen) {
                            PasswordVisualTransformation()
                        } else {
                            VisualTransformation.None
                        },
                        trailingIcon = {
                            IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                                if (!isPasswordOpen) {
                                    Icon(painter = painterResource(id = R.drawable.ic_red_eye),
                                        contentDescription = "",
                                        tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp))
                                } else {
                                    Icon(painter = painterResource(id = R.drawable.ic_remove_red_eye),
                                        contentDescription = "",
                                        tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp))
                                }
                            }
                        }
                    )

                    Button(onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor,
                            contentColor = Color.White),
                        contentPadding = PaddingValues(vertical = 14.dp)) {
                        Text(text = "로그인", fontFamily = NotoSans)
                    }

                    TextButton(onClick = {}, contentPadding = PaddingValues(vertical = 0.dp)) {
                        Text(text = "계정이 없다면? 회원가입",
                            color = LightTextColor,
                            fontFamily = NotoSans,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun BackGroundImage() {
    val isPlaying by remember {
        mutableStateOf(true)
    }

    val speed by remember {
        mutableStateOf(1f)
    }

    val composition by rememberLottieComposition(

        LottieCompositionSpec
            .RawRes(R.raw.landingapp)
    )

    val progress by animateLottieCompositionAsState(

        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = true

    )
    Box(contentAlignment = Alignment.TopCenter) {
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(340.dp)
        )
    }


}
