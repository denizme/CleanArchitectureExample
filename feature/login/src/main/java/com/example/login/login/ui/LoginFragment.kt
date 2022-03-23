package com.example.login.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment

class LoginFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_login

    override val binding by fragmentViewBinding(FragmentLoginBinding::bind)

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoRegister.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

    }

    override fun binds() {}
}