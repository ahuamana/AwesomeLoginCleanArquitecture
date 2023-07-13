package com.ahuaman.customloginglasseffect

import dagger.hilt.android.HiltAndroidApp
import dev.jakhongirmadaminov.glassmorphiccomposables.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class App() : android.app.Application() {
    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        super.onCreate()
    }
}