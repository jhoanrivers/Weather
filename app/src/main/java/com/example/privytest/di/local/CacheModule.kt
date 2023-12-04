package com.example.privytest.di.local

import android.content.Context
import android.content.SharedPreferences
import com.example.privytest.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CacheModule {


    @Singleton
    @Provides
    fun provideSharePreference(@ApplicationContext context: Context) : SharedPreferences {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }

}