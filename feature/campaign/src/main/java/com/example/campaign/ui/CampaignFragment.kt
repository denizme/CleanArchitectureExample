package com.example.campaign.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.campaign.R
import com.example.campaign.databinding.FragmentCampaignBinding
import com.example.presentation.binding.fragmentViewBinding
import com.example.presentation.fragments.BaseFragment

class CampaignFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_campaign

    override val binding by fragmentViewBinding(FragmentCampaignBinding::bind)

    private val viewModel: CampaignViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun binds() {}
}