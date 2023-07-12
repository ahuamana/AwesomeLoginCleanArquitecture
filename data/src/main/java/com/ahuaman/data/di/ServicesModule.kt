package com.ahuaman.data.di

import com.ahuaman.data.service.ReqresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {

    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit): ReqresService = retrofit.create(ReqresService::class.java)

}