package com.example.w365_android_client.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.w365_android_client.repository.User
import com.example.w365_android_client.repository.UserRepository
import com.example.w365_android_client.usecase.UserLoginUseCase
import kotlinx.coroutines.flow.*

class LoginViewModel : ViewModel() {
    fun isUserLoggedIn(): LiveData<Boolean> {
        val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData<Boolean>();
        UserLoginUseCase.observeUserStatusChanges().onEach {
            isUserLoggedIn.value = (it != null)
        }.launchIn(viewModelScope)

        return isUserLoggedIn
    }

    fun login(userName: String?, password: String?) {
        UserLoginUseCase.login(userName, password)
    }
}