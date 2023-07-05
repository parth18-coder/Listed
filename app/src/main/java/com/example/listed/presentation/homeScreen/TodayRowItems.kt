package com.example.listed.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TodayRowItems(
    imageId: Int,
    descriptionImage: String,
    dataText: String,
    data: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier)
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(imageId),
                contentDescription = descriptionImage,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .weight(1f)
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = data,
                modifier = Modifier.weight(1f),
                color = Color(0xFF000000)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = dataText,
                modifier = Modifier.weight(1f),
                color = Color(0xFF999CA0)
            )
        }

    }
}