package com.example.home.dashboard.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.home.R
import com.example.home.databinding.FragmentDashboardBinding
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_dashboard
    override val binding by fragmentViewBinding(FragmentDashboardBinding::bind)

    private val viewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
            val userName = binding.inputUserName.text.toString()
            if (!userName.isNullOrEmpty()) {
                //viewModel.searchUserRepos(userName)
            }
            binding.textMessage.text = "denizme"
        }


        binding.btnGoLogin.setOnClickListener {
            val uri = Uri.parse("myApp://LoginFragment/mehmet?surName=deniz&age=23")
            val navOptions = NavOptions.Builder()
                .setPopUpTo(
                    "myApp://LoginFragment/mehmet?surName=deniz&age=23",
                    true
                )
                .build()

            findNavController().navigate(deepLink = uri, navOptions = navOptions)
        }

    }

    override fun binds() {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            binding.textMessage.text = it
        }

        lifecycleScope.launchWhenCreated {
            viewModel.userRepoList.observe(viewLifecycleOwner) {
                binding.textMessage.text = "Repo count : ${it.size}"
                it.forEach {
                    Log.d("REPO NAME : ", it.name)
                }
            }
        }
    }
}