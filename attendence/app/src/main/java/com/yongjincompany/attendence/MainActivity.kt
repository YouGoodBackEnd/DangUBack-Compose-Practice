package com.yongjincompany.attendence

import RegisterScreen
import android.graphics.Region
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yongjincompany.attendence.composables.BackGroundImage
import com.yongjincompany.attendence.composables.LoginArea
import com.yongjincompany.attendence.composables.LoginScreen
import com.yongjincompany.attendence.ui.Screen
import com.yongjincompany.attendence.ui.theme.AttendenceTheme
import com.yongjincompany.attendence.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttendenceTheme {
                Surface(color = PrimaryColor,
                    modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController as NavHostController, startDestination = Screen.RegisterScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
    }
}



