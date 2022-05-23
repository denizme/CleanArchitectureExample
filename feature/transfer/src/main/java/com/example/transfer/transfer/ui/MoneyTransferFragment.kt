package com.example.transfer.transfer.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.extensions.observe
import com.example.core.helper.ThemePreferenceRepository
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseViewModelFragment
import com.example.transfer.R
import com.example.transfer.databinding.FragmentMoneyTransferBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoneyTransferFragment : BaseViewModelFragment<MoneyTransferViewState, MoneyTransferViewModel>() {

    override val layoutResId = R.layout.fragment_money_transfer

    override val binding by fragmentViewBinding(FragmentMoneyTransferBinding::bind)

    override val viewModel: MoneyTransferViewModel by viewModels()

    @Inject
    lateinit var themePreferenceRepository: ThemePreferenceRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        themeProcess()
        binding.awesomeCustomView.setImage("https://i4.hurimg.com/i/hurriyet/75/750x422/628a8c724e3fe002f489ca06.jpg")
    }

    override fun binds() {
        lifecycleScope.launchWhenCreated {
            observe(viewModel.viewState) { renderViewState(it) }
        }
    }

    override fun renderViewState(viewState: MoneyTransferViewState) {
        when (viewState) {
            is MoneyTransferViewState.Loading -> {}
            is MoneyTransferViewState.Error -> {}
        }
    }

    private fun themeProcess() {
        themePreferenceRepository.isDarkThemeLive.observe(this) { isDarkTheme ->
            isDarkTheme?.let { binding.darkThemeSwitch.isChecked = it }
        }
        binding.darkThemeSwitch.setOnCheckedChangeListener { _, checked ->
            themePreferenceRepository.isDarkTheme = checked
        }
    }
}