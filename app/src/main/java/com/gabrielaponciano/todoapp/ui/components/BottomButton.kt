package com.gabrielaponciano.todoapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gabrielaponciano.todoapp.ui.theme.buttonBlue

@Composable
fun SimuScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        BottomButton(title = "Criar") {

        }

    }
}

@Composable
fun BottomButton(title:String, onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .height(48.dp)
                .width(327.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(buttonBlue)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, fontSize = 12.sp, color = Color.White)
        }
    }
}

@Preview
@Composable
fun ButtomButtonPreview(){
    SimuScreen()
}