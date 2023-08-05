package com.example.vrach.network.customer

import com.example.vrach.model.customer.Customer
import com.example.vrach.model.customer.SuccessMessage
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface CustomerApiService {
    @POST("/v1/register")
    suspend fun createAccount(@Body customer: Customer): Response<SuccessMessage>
}