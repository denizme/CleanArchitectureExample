package com.example.account.setting.ui

import androidx.fragment.app.viewModels
import com.example.account.R
import com.example.account.databinding.FragmentSettingBinding
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment  :BaseViewModelFragment<SettingViewState,SettingViewModel>(){

    override val layoutResId = R.layout.fragment_setting

    override val binding by fragmentViewBinding(FragmentSettingBinding::bind)

    override val viewModel: SettingViewModel by viewModels()

    override fun binds() {}

    override fun renderViewState(viewState: SettingViewState) {}
}