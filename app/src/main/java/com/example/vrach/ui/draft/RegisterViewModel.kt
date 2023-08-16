package com.example.vrach.ui.draft

import com.example.vrach.network.draft.CustomerApiService
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Retrofit

fun postMethod() {
    rawJSON()
}


fun rawJSON() {

    // Create Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2")
        .build()

    // Create Service
    val service = retrofit.create(CustomerApiService::class.java)

    // Create JSON using JSONObject
    val jsonObject = JSONObject()
    jsonObject.put("firstname", "Medusa")
    jsonObject.put("lastname", "Olimpus")
    jsonObject.put("date_of_birth", "10/20/1111")
    jsonObject.put("email", "medusa.servaiv@gmail.com")
    jsonObject.put("gender", 2)
    jsonObject.put("username", "medusa123")
    jsonObject.put("password","Etogege1234")

    // Convert JSONObject to String
    val jsonObjectString = jsonObject.toString()

    // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
    val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())

    CoroutineScope(Dispatchers.IO).launch {
        // Do the POST request and get response
        val response = service.createAccount(requestBody)

        withContext(Dispatchers.Main) {
            if (response.isSuccessful) {

                // Convert raw JSON to pretty JSON using GSON library
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