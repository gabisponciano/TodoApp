package com.gabrielaponciano.todoapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gabrielaponciano.todoapp.model.TaskModel
import com.gabrielaponciano.todoapp.ui.components.CardItem
import com.gabrielaponciano.todoapp.ui.components.TopBarHome
import com.gabrielaponciano.todoapp.ui.viewmodels.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScreen(){
    val homeViewModel = koinViewModel<HomeViewModel>()

    val tasks by homeViewModel.listAll.collectAsState()

    Scaffold (
        topBar = {
            TopBarHome {

            }
        },
    ){
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.White)){
            LazyColumn {
                    items(tasks){task ->
                        CardItem(title = task.title, description = task.description, status = task.status)


                    }

//                items(listAllTask){ task ->
//                    CardItem(title = task.title , description = task.description, status = task.status )
//
//                }
            }


        }

    }
}




