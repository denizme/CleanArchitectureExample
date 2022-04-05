package com.example.campaign.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.campaign.R
import com.example.campaign.databinding.FragmentCampaignBinding
import com.example.core.ui.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment
import com.example.presentation.fragments.BaseViewModelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CampaignFragment : BaseViewModelFragment<CampaignViewState, CampaignViewModel>() {

    override val layoutResId: Int = R.layout.fragment_campaign

    override val binding by fragmentViewBinding(FragmentCampaignBinding::bind)

    override val viewModel: CampaignViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun binds() {}

    override fun renderViewState(viewState: CampaignViewState) {}
}