package com.example.listed.data.remote

import com.example.listed.data.remote.dto.ListedDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object MakeApiRequest {
//    suspend fun makeApiRequest(onResponse: (Response<ListedDto>) -> Unit) {
//        val token =
//            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.inopenapp.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val apiService = retrofit.create(ListedApi::class.java)
//        val call = apiService.getListing(token)
//
//        call.enqueue(object : Callback<ListedDto> {
//            override fun onResponse(call: Call<ListedDto>, response: Response<ListedDto>) {
//                onResponse(response)
//            }
//
//            override fun onFailure(call: Call<ListedDto>, t: Throwable) {
//                // Handle failure case
//            }
//        })
//    }
//}