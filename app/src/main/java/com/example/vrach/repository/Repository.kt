package com.example.vrach.repository

import com.example.vrach.api.RetrofitInstance
import com.example.vrach.model.Customer
import okhttp3.RequestBody

class Repository {
    /*suspend fun createAccount(customer: Customer): Response<Customer> {
        return RetrofitInstance.api.createAccount(customer)
    }*/

    suspend fun createAccountcc(customer: RequestBody) {
        RetrofitInstance.api.createAccount(customer)
    }

    companion object {
        suspend fun createAccount(customer: RequestBody) {
            RetrofitInstance.api.createAccount(customer)
        }
    }
}