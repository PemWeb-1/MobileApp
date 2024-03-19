package com.example.faker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakeStoreApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // to do things if you wanted
    }
}