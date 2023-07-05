package com.example.listed.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listed.data.remote.dto.ListedDto

@Composable
fun ListOfLinks(dataState: ListedDto?) {

    val ovalShape = remember { RoundedCornerShape(50.dp) }

    var linkState by remember{ mutableStateOf("top links")}

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .background(Color(0xFF0E6FFF), ovalShape)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .clickable { linkState="top links"}, contentAlignment = Alignment.Center
            ) {
                Text(text = "Top Links", fontSize = 16.sp,color= Color(0xFFFFFFFF))
            }
            Spacer(modifier = Modifier.width(6.dp))
            Box(
                modifier = Modifier
                    .background(Color(0xFF0E6FFF), ovalShape)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                    .clickable {linkState="recent links" }, contentAlignment = Alignment.Center
            ) {
                Text(text = "Recent Links", fontSize = 16.sp,color= Color(0xFFFFFFFF))
            }
        }

    }

    Spacer(modifier = Modifier.height(8.dp))


    Box(modifier = Modifier.height(200.dp)) {
        val topLinksList = dataState?.data?.topLinks
        val recentLinksList=dataState?.data?.recentLinks

        val showItemCount = remember { mutableStateOf(2) }


        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            if (topLinksList != null && recentLinksList!=null) {
                if(linkState=="top links") {
                    items(topLinksList.subList(0, showItemCount.value)) { item ->
                        topListItem(item)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                else if(linkState=="recent links"){
                    items(recentLinksList.subList(0, showItemCount.value)) { item ->
                        RecentListItem(item)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    if (showItemCount.value < topLinksList.size) {
                        Button(onClick = {
                            showItemCount.value = topLinksList.size
                        }, modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF5F5F5),
                                contentColor = Color(0xFF000000)
                            )) {
                            Text(text = "View all links")
                        }
                    }

                    else if(showItemCount.value < recentLinksList.size){
                        Button(onClick = {
                            showItemCount.value = recentLinksList.size
                        }, modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF5F5F5),
                                contentColor = Color(0xFF000000)
                            )) {
                            Text(text = "View all links")
                        }

                    }
                }
            }

        }
    }
}