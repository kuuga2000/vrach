package com.example.vrach.api

import com.example.vrach.model.Customer
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface CustomerApi {
    @POST("/v1/register")
    suspend fun createAccount(@Body requestBody: RequestBody): Response<ResponseBody>
}