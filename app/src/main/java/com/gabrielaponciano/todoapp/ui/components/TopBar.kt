package com.gabrielaponciano.todoapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gabrielaponciano.todoapp.ui.theme.buttonBlue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopBarSimu(){
    Scaffold (
        topBar = { TopBarHome {

        }}
    ){innerPadding->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)){

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome(onClick: ()-> Unit){
    CenterAlignedTopAppBar(
        modifier = Modifier.padding(5.dp),
        colors = topAppBarColors(
            containerColor = Color.White
        ),
        title = {
            Text("Projeto",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
        },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = buttonBlue)

            }
        }

    )
}

@Preview
@Composable
fun TopBarScreen(){
    TopBarSimu()
}