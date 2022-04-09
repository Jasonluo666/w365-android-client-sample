package com.example.w365_android_client.usecase

import com.example.w365_android_client.repository.User
import com.example.w365_android_client.repository.UserRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object UserLoginUseCase {
    fun isUserLoggedIn(): Boolean {
        return UserRepository.user != null
    }

    fun observeUserStatusChanges(): StateFlow<User?> {
        return UserRepository.onUserStatusChanges
    }

    fun login(userName: String?, password: String?): User {
        // TODO

        val currentUser = User(userName?: "123", password?: "123")
        UserRepository.updateUser(currentUser)

        return currentUser
    }

    fun logout(): Boolean {
        // TODO

        UserRepository.removeUser()
        return true
    }
}