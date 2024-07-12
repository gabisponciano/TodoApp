package com.gabrielaponciano.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.todoapp.ui.screens.HomeScreen
import com.gabrielaponciano.todoapp.ui.screens.NewTaskScreen
import com.gabrielaponciano.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                val navController = rememberNavController()
                Navigation(navController)

                }
            }
        }
    }

object Routes {
    const val HOME = "home"
    const val CHANGE_TASK = "change"
    const val NEW_TASK = "task"

}

@Composable
fun Navigation(navController: NavHostController){
//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME){
        composable(Routes.HOME){
            HomeScreen(navController)
        }
        composable(Routes.NEW_TASK){
            NewTaskScreen(navController)
        }
        composable(Routes.CHANGE_TASK){

        }
    }
}
