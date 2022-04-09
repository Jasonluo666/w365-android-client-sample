package com.example.w365_android_client.usecase

import com.example.w365_android_client.repository.User
import com.example.w365_android_client.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserLoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    fun isUserLoggedIn(): Boolean {
        return true
    }

    fun observeUserStatusChanges(): StateFlow<User?> {
        return MutableStateFlow<User?>(null)
    }

    fun login(userName: String?, password: String?): User {
        // TODO

        val currentUser = User(userName?: "123", password?: "123")
        userRepository.updateUser(currentUser)

        return currentUser
    }

    fun logout(): Boolean {
        // TODO

        userRepository.removeUser()
        return true
    }
}