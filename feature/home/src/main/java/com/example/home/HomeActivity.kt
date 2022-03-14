package com.example.home

import android.os.Bundle
import com.example.home.dashboard.ui.DashboardFragment
import com.example.presentation.activities.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, DashboardFragment())
                .commit()
        }
    }

}