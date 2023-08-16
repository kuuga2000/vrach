package com.example.vrach.utils

object Utils {

    fun firstname(fullname: String? = null): String? {
        var firstname: String? = null
        if (fullname != null) {
            val elimenator = " "

            val arr = fullname.split(elimenator).toTypedArray()
            firstname = arr[0]
        }
        return firstname
    }

    fun lastname(fullname: String? = null): String? {
        var lastname: String? = null
        if (fullname != null) {
            val elimenator = " "

            val arr = fullname.split(elimenator).toTypedArray()
            if (arr.size > 1) {
                lastname = arr[1]
            } else {
                lastname = arr[0]
            }
        }
        return lastname
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}