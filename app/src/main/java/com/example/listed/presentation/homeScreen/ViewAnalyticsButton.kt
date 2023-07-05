package com.example.listed.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.listed.R

@Composable
fun ViewAnalyticsButton(){
    Column() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(8.dp)){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { }
                    .border(
                        BorderStroke(1.dp, color = Color(0xFFD8D8D8)),
                        shape = RoundedCornerShape(8.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.view_analystics_button),
                    contentDescription = "zic-zac arrow",
                    modifier= Modifier
                        .height(32.dp)
                        .width(32.dp)
                )
                Text(text="  View Analytics",color= Color(0xFF000000))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

    }
}