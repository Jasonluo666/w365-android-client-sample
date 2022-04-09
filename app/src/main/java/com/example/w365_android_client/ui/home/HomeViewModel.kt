package com.example.w365_android_client.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.w365_android_client.repository.User
import com.example.w365_android_client.usecase.UserLoginUseCase

class HomeViewModel : ViewModel() {
    val isLoggedIn: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(null)
    }

    fun checkUserStatus() {
        // TODO
        isLoggedIn.value = UserLoginUseCase.isUserLoggedIn()
    }

    fun logout() {
        UserLoginUseCase.logout()
        isLoggedIn.value = false
    }
}