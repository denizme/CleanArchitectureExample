package com.example.login.register.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.extensions.fromJson
import com.example.login.R
import com.example.login.databinding.FragmentRegisterBinding
import com.example.login.login.data.UserData
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment

class RegisterFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_register

    override val binding by fragmentViewBinding(FragmentRegisterBinding::bind)

    private val viewModel: RegisterViewModel by viewModels()

    private val args: RegisterFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoDashboard.setOnClickListener {
            val uri = Uri.parse("home://DashboardFragment")
            findNavController().navigate(uri)
        }
        val userData = args.userdata.fromJson(UserData::class.java)
        Log.d("LOG - USER NAME", userData.name)
        Log.d("LOG - USER SURNAME", userData.surname)
    }

    override fun binds() {}
}