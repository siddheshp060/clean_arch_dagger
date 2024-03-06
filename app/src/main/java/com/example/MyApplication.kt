package com.example

import android.app.Application
import com.example.daggermvvmapp.ApplicationComponent
import com.example.daggermvvmapp.DaggerApplicationComponent

class MyApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}