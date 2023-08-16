package com.example.vrach.repository.customer

import com.example.vrach.model.customer.Customer
import com.example.vrach.model.customer.SuccessMessage
import com.example.vrach.network.customer.CustomerInstance
import retrofit2.Response

class CustomerRepository {
    /*suspend fun createAccount(customer: Customer): Response<Customer> {
        return RetrofitInstance.api.createAccount(customer)
    }*/

    companion object {
        suspend fun createAccount(customer: Customer): Response<SuccessMessage> {
            return CustomerInstance.api.createAccount(customer)
        }
    }
}
