package com.example.w365_android_client.repository

import androidx.lifecycle.MutableLiveData

object UserRepository {
    private var _user: User? = null

    val user: User?
        get() = _user

    fun updateUser(currentUser: User) {
        _user = currentUser
    }

    fun removeUser() {
        _user = null
    }
}

data class User (
    val username: String = "",
    val userId: String = "",
)