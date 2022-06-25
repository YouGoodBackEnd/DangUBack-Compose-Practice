package com.yongjincompany.attendence

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.yongjincompany.attendence.composables.LoginScreen
import com.yongjincompany.attendence.ui.theme.AttendenceTheme
import com.yongjincompany.attendence.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendenceTheme {
                androidx.compose.material.Surface(color = PrimaryColor,
                    modifier = Modifier.fillMaxSize()) {
                    LoginScreen()
                }
            }
        }
    }
}

