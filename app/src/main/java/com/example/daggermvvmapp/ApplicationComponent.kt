package com.example.daggermvvmapp

import com.example.daggermvvmapp.di.NetworkingModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkingModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}