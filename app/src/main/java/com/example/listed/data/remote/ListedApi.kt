package com.example.listed.data.remote

import com.example.listed.data.remote.dto.ListedDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ListedApi {

    @GET("api/v1/dashboardNew")
    suspend fun getListing(
        @Header("Authorization") token: String
    ): Response<ListedDto>

}