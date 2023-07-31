package com.example.vrach.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface CustomerApiService {
    @POST("/v1/register")
    suspend fun createAccount(@Body requestBody: RequestBody): Response<ResponseBody>
}