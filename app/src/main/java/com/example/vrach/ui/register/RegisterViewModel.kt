package com.example.vrach.ui.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.vrach.model.customer.Customer
import com.example.vrach.model.LoginDataState
import com.example.vrach.repository.customer.CustomerRepository
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.update
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class LoginViewModel : ViewModel() {

    private val _uiLoginState = MutableStateFlow(LoginDataState())
    val uiLoginState: StateFlow<LoginDataState> = _uiLoginState.asStateFlow()

    fun setLoginData(newLoginData: LoginDataState) {
        updateLoginData(newLoginData)
    }

    fun resetOrder() {
        _uiLoginState.value = LoginDataState()
    }

    private fun updateLoginData(newLoginData: LoginDataState) {
        _uiLoginState.update { currentState ->
            val username = newLoginData?.username
            val password = newLoginData?.password
            currentState.copy(
                username = username,
                password = password,
            )
        }
    }

    fun crateAccount(customer: Customer) {
        CoroutineScope(Dispatchers.IO).launch {
            val jsonObject = Gson().toJson(customer)
            val jsonObjectString = jsonObject.toString()
            Log.d("ssd",jsonObjectString)
            val requestBody = jsonObjectString
                .toRequestBody("application/json".toMediaTypeOrNull())
            CustomerRepository.createAccount(requestBody)
        }
    }
}
