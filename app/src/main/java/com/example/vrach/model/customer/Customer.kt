package com.example.vrach.model.customer

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Customer(
    val firstname: String? = null,
    val lastname: String? = null,
    val nickname: String? = null,
    @SerializedName("date_of_birth")
    val dateOfBirth: String? = null,
    val email: String? = null,
    val gender: Int? = null,
    val username: String? = null,
    val password: String? = null
)

@Serializable
data class SuccessMessage(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("message") val message: String? = null
)
