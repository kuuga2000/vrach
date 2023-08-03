package com.example.vrach.ui.register

import com.example.vrach.network.CustomerApiService
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vrach.model.Customer
import com.example.vrach.model.LoginDataState
import com.example.vrach.repository.Repository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.update
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Retrofit

fun createAccount() {
    setAccountData()
}

fun setAccountData() {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2")
        .build()

    val service = retrofit.create(CustomerApiService::class.java)
    val jsonObject = JSONObject()
    jsonObject.put("firstname", "Medusa")
    jsonObject.put("lastname", "Olimpus")
    jsonObject.put("date_of_birth", "10/20/1111")
    jsonObject.put("email", "medusa.servaiv@gmail.com")
    jsonObject.put("gender", 2)
    jsonObject.put("username", "medusa123")
    jsonObject.put("password", "Etogege1234")

    val jsonObjectString = jsonObject.toString()
    val requestBody = jsonObjectString
        .toRequestBody("application/json".toMediaTypeOrNull())

    CoroutineScope(Dispatchers.IO).launch {
        val response = service.createAccount(requestBody)
        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {
                val gson = GsonBuilder().setPrettyPrinting().create()
                val prettyJson = gson.toJson(
                    JsonParser.parseString(
                        response.body()
                            ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                    )
                )
                Log.d("Pretty Printed JSON :", prettyJson)
            } else {
                Log.e("RETROFIT_ERROR", response.code().toString())
            }
        }
    }
}

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
            Repository.createAccount(requestBody)
        }
    }
}
