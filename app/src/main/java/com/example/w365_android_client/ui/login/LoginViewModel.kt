package com.example.w365_android_client.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.w365_android_client.repository.User
import com.example.w365_android_client.repository.UserRepository
import com.example.w365_android_client.usecase.UserLoginUseCase

class LoginViewModel : ViewModel() {
    val user: MutableLiveData<User?> by lazy {
        MutableLiveData<User?>(null)
    }

    fun login(userName: String?, password: String?) {
        val currentUser = UserLoginUseCase.login(userName, password)

        user.value = currentUser
    }
}