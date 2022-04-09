package com.example.w365_android_client.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w365_android_client.R
import com.example.w365_android_client.repository.User
import com.example.w365_android_client.usecase.UserLoginUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel : ViewModel() {
    fun isUserLoggedIn(): LiveData<Boolean> {
        val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData<Boolean>();
        UserLoginUseCase.observeUserStatusChanges().onEach {
            isUserLoggedIn.value = (it != null)
        }.launchIn(viewModelScope)

        return isUserLoggedIn
    }

    fun logout() {
        UserLoginUseCase.logout()
    }
}