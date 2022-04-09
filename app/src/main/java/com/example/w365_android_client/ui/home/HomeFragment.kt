package com.example.w365_android_client.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.w365_android_client.R
import com.example.w365_android_client.databinding.HomeFragmentBinding
import com.example.w365_android_client.databinding.LoginFragmentBinding
import com.example.w365_android_client.ui.login.LoginViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        navController = findNavController()
        homeViewModel = ViewModelProvider(activity as FragmentActivity, viewModelFactory)
            .get(HomeViewModel::class.java)

        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.isUserLoggedIn().observe(viewLifecycleOwner, Observer<Boolean> { res ->
            if (!res) {
                navController.navigate(R.id.navigation_login)
            }
        })
    }

}