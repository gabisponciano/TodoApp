package com.gabrielaponciano.todoapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gabrielaponciano.todoapp.ui.components.TopBarHome

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScreen(){
    Scaffold (
        topBar = {
            TopBarHome {

            }
        }
    ){
        Column (modifier = Modifier.fillMaxSize().background(Color.White)){



        }

    }
}