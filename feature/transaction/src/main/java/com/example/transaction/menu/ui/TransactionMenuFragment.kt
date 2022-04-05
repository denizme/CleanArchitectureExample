package com.example.transaction.menu.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.extensions.observe
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import com.example.transaction.R
import com.example.transaction.databinding.FragmentTransactionMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionMenuFragment :
    BaseViewModelFragment<TransactionMenuViewState, TransactionMenuViewModel>() {

    override val layoutResId = R.layout.fragment_transaction_menu

    override val binding by fragmentViewBinding(FragmentTransactionMenuBinding::bind)

    override val viewModel: TransactionMenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoLogin.setOnClickListener {
            val uri = Uri.parse("login://LoginFragment")
            findNavController().navigate(deepLink = uri)
        }
    }

    override fun binds() {
        lifecycleScope.launchWhenCreated {
            observe(viewModel.viewState) { renderViewState(it) }
        }
    }

    override fun renderViewState(viewState: TransactionMenuViewState) {
        when (viewState) {
            is TransactionMenuViewState.Loading -> {}
            is TransactionMenuViewState.Error -> {}
        }
    }
}