package com.example.listed.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listed.R

@Composable
fun NameComposable(){
    Box(modifier = Modifier
        .fillMaxWidth() ){
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Good Morning", fontSize = 16.sp,color= Color(0xFF999CA0))
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Ajay Manva ", fontSize = 24.sp,color= Color(0xFF000000))
                Image(
                    painter = painterResource(id = R.drawable.hey_image),
                    contentDescription = "hey Emoji"
                )
            }
        }
    }
}