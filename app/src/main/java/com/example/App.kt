package com.example

import com.example.core.CoreApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: CoreApp() {
    override fun onCreate() {
        super.onCreate()
    }
}