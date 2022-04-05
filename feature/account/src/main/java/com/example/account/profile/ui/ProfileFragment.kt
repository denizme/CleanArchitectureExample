package com.example.account.profile.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.account.R
import com.example.account.databinding.FragmentProfileBinding
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseViewModelFragment<ProfileViewState, ProfileViewModel>() {

    override val layoutResId = R.layout.fragment_profile

    override val binding by fragmentViewBinding(FragmentProfileBinding::bind)

    override val viewModel: ProfileViewModel by viewModels()

    private val args: ProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvInfo.text ="${args.name} - ${args.surname} - ${args.age}"
    }

    override fun binds() {
        binding.btnGoSetting.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingFragment)
        }
    }

    override fun renderViewState(viewState: ProfileViewState) {}
}