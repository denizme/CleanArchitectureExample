package com.example.login.login.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.toJson
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.login.login.data.UserData
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment

class LoginFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_login

    override val binding by fragmentViewBinding(FragmentLoginBinding::bind)

    private val viewModel: LoginViewModel by viewModels()

    private val args: LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvArg.text = args.userName + " " + args.surName + " " + args.age

        binding.btnGoRegister.setOnClickListener {
            val userData = UserData(name = "mehmhet", surname = "deniz")
            val uri = Uri.parse("myApp://RegisterFragment?userdata=${userData.toJson()}")
            findNavController().navigate(uri)
        }
    }

    override fun binds() {}
}