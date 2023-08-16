package com.example.vrach.ui.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.vrach.model.LoginDataState
import com.example.vrach.model.customer.Customer
import com.example.vrach.repository.customer.CustomerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            val res = CustomerRepository.createAccount(customer)
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    res.body()?.message?.let { Log.d("Pretty Printed JSON :", it) }
                } else {
                    Log.e("RETROFIT_ERROR", res.code().toString())
                }
            }
        }
    }
}
