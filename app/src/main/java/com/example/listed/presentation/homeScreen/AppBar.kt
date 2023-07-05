package com.example.listed.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun myAppBar(){
    TopAppBar(
        title = {
            Text(text = "DashBoard", fontSize = 24.sp)
        },
        backgroundColor = Color(0xFF0E6FFF),
        modifier = Modifier.height(120.dp),
        contentColor = Color(0xFFFFFFFF),
        elevation = 4.dp // Optional: Add elevation to the app bar
    )
}