package com.gabrielaponciano.todoapp.ui.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gabrielaponciano.todoapp.ui.components.BottomButton
import com.gabrielaponciano.todoapp.ui.components.LockScreenOrientation
import com.gabrielaponciano.todoapp.ui.components.TopBarNav
import com.gabrielaponciano.todoapp.ui.theme.backButton
import com.gabrielaponciano.todoapp.ui.theme.dividerColor
import com.gabrielaponciano.todoapp.ui.theme.textfield
import com.gabrielaponciano.todoapp.ui.viewmodels.NewTaskViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewTaskScreen(navController: NavController){
    val taskViewModel = koinViewModel<NewTaskViewModel>()
    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


    Scaffold (
        topBar = {
            TopBarNav()
        },
        bottomBar = {
            BottomAppBar (containerColor = Color.White){
                BottomButton(title = "Criar") {
                    taskViewModel.saveTask()

                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(300.dp),
        ) {
            Box(
                modifier = Modifier
                    .height(320.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = taskViewModel.title,
                        onValueChange = { taskViewModel.title = it },
                        singleLine = true,
                        label = { Text(text = ("Título"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Divider(
                        color = dividerColor,
                        thickness = 1.dp,
                        modifier = Modifier.width(343.dp)
                    )

                    OutlinedTextField(
                        value = taskViewModel.description,
                        onValueChange = { taskViewModel.description = it },
                        label = { Text(text = ("Descrição"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Divider(
                        color = dividerColor,
                        thickness = 1.dp,
                        modifier = Modifier.width(343.dp)
                    )

                    OutlinedTextField(
                        value = taskViewModel.status,
                        onValueChange = { taskViewModel.status = it },
                        label = { Text(text = ("Descrição"), color = textfield, fontSize = 14.sp) },
                        modifier = Modifier
                            .width(343.dp)
                            .height(52.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                }

            }

        }

            Divider(color = dividerColor, thickness = 1.dp, modifier = Modifier.width(343.dp))



                }

}

@Preview
@Composable
fun NewTaskPreview(){
    NewTaskScreen(navController = rememberNavController())
}