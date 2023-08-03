package com.example.vrach.repository.customer

import com.example.vrach.network.customer.CustomerInstance
import okhttp3.RequestBody

class CustomerRepository {
    /*suspend fun createAccount(customer: Customer): Response<Customer> {
        return RetrofitInstance.api.createAccount(customer)
    }*/

    suspend fun createAccountcc(customer: RequestBody) {
        CustomerInstance.api.createAccount(customer)
    }

    companion object {
        suspend fun createAccount(customer: RequestBody) {
            CustomerInstance.api.createAccount(customer)
        }
    }
}
