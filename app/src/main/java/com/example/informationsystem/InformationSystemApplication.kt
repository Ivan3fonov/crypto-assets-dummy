package com.example.informationsystem

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InformationSystemApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}