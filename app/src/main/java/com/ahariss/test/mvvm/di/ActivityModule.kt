package com.ahariss.test.mvvm.di

import android.app.Activity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideMainAcitvityImp(activity: Activity) = activity as MainAcitvityImp.Callback
}