package com.example.w365_android_client.di

import android.content.Context
import com.example.w365_android_client.ui.MainActivity
import com.example.w365_android_client.ui.home.HomeFragment
import com.example.w365_android_client.ui.login.LoginFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
// Definition of a Dagger component
@Component(modules = [
    AuthModule::class,
    ViewModelModule::class,
])
interface AppComponent {
    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // UI classes that can be injected by this Component
    fun inject(activity: MainActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: HomeFragment)
}