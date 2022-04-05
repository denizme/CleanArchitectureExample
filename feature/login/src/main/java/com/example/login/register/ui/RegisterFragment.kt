package com.example.login.register.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.login.R
import com.example.login.databinding.FragmentRegisterBinding
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseViewModelFragment<RegisterViewState, RegisterViewModel>() {

    override val layoutResId: Int = R.layout.fragment_register

    override val binding by fragmentViewBinding(FragmentRegisterBinding::bind)

    override val viewModel: RegisterViewModel by viewModels()

    private val args: RegisterFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun binds() {}

    override fun renderViewState(viewState: RegisterViewState) {}
}