package com.example.listed.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.listed.R
import com.example.listed.data.remote.dto.ListedDto
import com.example.listed.presentation.TodayRowItems

@Composable
fun TodayComposable(dataState: ListedDto?){
    Box(modifier = Modifier
        .height(120.dp)
        .fillMaxWidth()
        .padding(8.dp)) {
        Row(modifier = Modifier.fillMaxSize()) {
            TodayRowItems(
                imageId = R.drawable.today_click_icon,
                descriptionImage = "today clicks icon",
                dataText = "Today's clicks",
                data = dataState?.todayClicks.toString() ?: "",
                modifier= Modifier
                    .weight(1f)
                    .height(120.dp)
                    .width(80.dp)
                    .background(Color(0xFFFFFFFF))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier
                .width(10.dp)
                .fillMaxHeight())
            TodayRowItems(
                imageId = R.drawable.top_location_icon,
                descriptionImage = "location icon",
                dataText = "Top Location",
                data = dataState?.topLocation ?: "",
                modifier= Modifier
                    .weight(1f)
                    .height(120.dp)
                    .width(80.dp)
                    .background(Color(0xFFFFFFFF))
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier
                .width(10.dp)
                .fillMaxHeight())
            TodayRowItems(
                imageId = R.drawable.top_source_icon,
                descriptionImage = "globe icon",
                dataText = "Top source",
                data = dataState?.topSource ?: "",
                modifier= Modifier
                    .weight(1f)
                    .height(120.dp)
                    .width(80.dp)
                    .background(Color(0xFFFFFFFF))
                    .padding(8.dp)
            )
        }

    }
}
