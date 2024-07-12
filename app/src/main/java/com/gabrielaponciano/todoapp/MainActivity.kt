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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.todoapp.ui.screens.NewTaskScreen
import com.gabrielaponciano.todoapp.ui.theme.TodoAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

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

@Composable
fun Navigation(navController:NavHostController){
//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "task"){
        composable("home"){
            //homeScreen(navController)
        }
        composable("task"){
            NewTaskScreen(navController)
        }
        composable("change"){

        }
    }
}

