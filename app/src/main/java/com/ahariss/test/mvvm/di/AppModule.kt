package com.ahariss.test.mvvm.di

import android.content.Context
import com.ahariss.test.mvvm.data.database.MarvelDatabase
import com.ahariss.test.mvvm.data.database.interfaces.MarvelCharacterDao
import com.ahariss.test.mvvm.data.network.RemoteDataSource
import com.ahariss.test.mvvm.data.network.service.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAPIService(
        @ApplicationContext context: Context,
        remoteDataSource: RemoteDataSource
    ): APIService {
        return remoteDataSource.buildApi(APIService::class.java, context)
    }
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): MarvelDatabase {
        return MarvelDatabase.getDatabase(context)
    }
}