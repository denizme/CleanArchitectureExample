package com.example.home.dashboard.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.home.R
import com.example.home.databinding.FragmentHomeDashboardBinding
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_home_dashboard
    override val binding by fragmentViewBinding(FragmentHomeDashboardBinding::bind)

    private val viewModel: DashboardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
            val userName = binding.inputUserName.text.toString()
            if (!userName.isNullOrEmpty()) {
                viewModel.searchUserRepos(userName)
            }
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