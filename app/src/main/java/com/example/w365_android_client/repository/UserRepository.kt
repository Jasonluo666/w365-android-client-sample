package com.example.w365_android_client.repository

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object UserRepository {
    private var _user: User? = null

    private val _onUserStatusChanges: MutableStateFlow<User?> = MutableStateFlow(null)
    val onUserStatusChanges: StateFlow<User?> get() = _onUserStatusChanges

    val user: User?
        get() = _user

    fun updateUser(currentUser: User) {
        _user = currentUser

        _onUserStatusChanges.value = _user
    }

    fun removeUser() {
        _user = null

        _onUserStatusChanges.value = _user
    }
}

data class User (
    val username: String = "",
    val userId: String = "",
)