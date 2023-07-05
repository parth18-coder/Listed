package com.example.listed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.listed.Model.MyViewModel
import com.example.listed.Model.MyViewModelFactory
import com.example.listed.data.remote.ListedApi
import com.example.listed.data.remote.dto.ListedDto
import com.example.listed.data.remote.dto.TopLinks
import com.example.listed.presentation.NameComposable
import com.example.listed.presentation.ViewAnalyticsButton
import com.example.listed.presentation.homeScreen.ChartComposable
import com.example.listed.presentation.homeScreen.ListOfLinks
import com.example.listed.presentation.homeScreen.TodayComposable
import com.example.listed.presentation.myAppBar
import com.example.listed.ui.theme.ListedTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.inopenapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ListedApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue_status_bar)

        setContent {
            MyComposableFunction(apiService = apiService)
        }
    }
}

@Composable
fun MyComposableFunction(apiService:ListedApi) {

    val viewModel: MyViewModel = viewModel(factory = MyViewModelFactory(apiService))
    val dataState: ListedDto? by viewModel.dataState


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F5F5)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            myAppBar()

            Box(
                modifier = Modifier
                    .size(700.dp)
                    .background(Color(0xFFF5F5F5))
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp)
                    )

            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ){
                    item{
                        Spacer(modifier = Modifier.height(20.dp))
                        NameComposable()
                    }
                    item {
                        Spacer(modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth())
                    }

                    item {
                        ChartComposable(dataState)
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        TodayComposable(dataState = dataState)
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        ViewAnalyticsButton()
                    }
                    item {
                        ListOfLinks(dataState = dataState)

                    }
                }
            }
        }
    }
}



