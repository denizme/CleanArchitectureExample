package com.example.login.register.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentRegisterBinding
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment

class RegisterFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_register

    override val binding by fragmentViewBinding(FragmentRegisterBinding::bind)

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoDashboard.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_dashboard)
        }
    }

    override fun binds() {}
}