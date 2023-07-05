package com.example.listed.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.listed.data.remote.dto.RecentLink
import com.example.listed.data.remote.dto.TopLinks

@Composable
fun RecentOriginalImageFetching(url: String?, modifier: Modifier = Modifier): ImagePainter {
    return rememberImagePainter(url)
}

@Composable
fun RecentListItem(item: RecentLink?){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFFFFFFFF))) {
        Column(modifier= Modifier
            .fillMaxSize()
            .padding(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                val painter= RecentOriginalImageFetching(url = item?.originalImage)
                Box(modifier= Modifier
                    .size(120.dp)
                    .weight(1f),
                    contentAlignment = Alignment.Center) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(150.dp)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                Column(modifier= Modifier.weight(1f)) {
                    Text(text = item?.urlPrefix?: "")
                    Text(text= item?.createdAt?: "")
                }

                Spacer(modifier = Modifier.width(20.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = item?.totalClicks.toString()?: "")
                    Text(text= "Clicks")
                }
            }
        }

    }

}