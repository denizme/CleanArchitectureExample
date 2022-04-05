package com.example.login.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseViewModelFragment<LoginViewState, LoginViewModel>() {

    override val layoutResId: Int = R.layout.fragment_login

    override val binding by fragmentViewBinding(FragmentLoginBinding::bind)

    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun binds() {}

    override fun renderViewState(viewState: LoginViewState) {}
}