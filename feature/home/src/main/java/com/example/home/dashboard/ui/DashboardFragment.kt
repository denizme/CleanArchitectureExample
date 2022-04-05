package com.example.home.dashboard.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.extensions.observe
import com.example.home.R
import com.example.home.databinding.FragmentDashboardBinding
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseViewModelFragment<DashboardViewState, DashboardViewModel>() {

    override val layoutResId: Int = R.layout.fragment_dashboard

    override val binding by fragmentViewBinding(FragmentDashboardBinding::bind)

    override val viewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
            val userName = binding.inputUserName.text.toString()
            if (!userName.isNullOrEmpty()) {
                viewModel.searchUserRepos(userName)
            }
        }

        binding.btnGoProfile.setOnClickListener {
            val name = "mehmet"
            val surname = "deniz"
            val age = 28
            val uri = Uri.parse("myApp://ProfileFragment/${name}?surname=${surname}&age=${age}")
            findNavController().navigate(deepLink = uri)
        }
    }

    override fun binds() {
        lifecycleScope.launchWhenCreated {
            observe(viewModel.viewState) { renderViewState(it) }
        }
    }

    override fun renderViewState(viewState: DashboardViewState) {
        when (viewState) {

            is DashboardViewState.Loading -> {}

            is DashboardViewState.Error -> {
                binding.textMessage.text = viewState.e.message
            }

            is DashboardViewState.UserRepoList -> {
                binding.textMessage.text = "Repo count : ${viewState.data.size}"
                viewState.data.forEach {
                    Log.d("REPO NAME : ", it.name)
                }
            }
        }
    }
}