package com.example.w365_android_client.di

import com.example.w365_android_client.ui.home.HomeViewModel
import com.example.w365_android_client.ui.login.LoginViewModel
import dagger.Component

@Component( modules = [
    ViewModelModule::class
])
interface ViewModelComponent {
    fun inject( viewModel: LoginViewModel)
    fun inject( viewModel: HomeViewModel)
}