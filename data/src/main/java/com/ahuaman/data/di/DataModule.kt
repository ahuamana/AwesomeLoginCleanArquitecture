package com.ahuaman.data.di

import com.ahuaman.data.remote.RemoteDataSource
import com.ahuaman.data.remote.RemoteDataSourceImpl
import com.ahuaman.data.repository.Repository
import com.ahuaman.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    @Singleton
    abstract fun provideMoviesRepository(
        moviesRepositoryImpl: RepositoryImpl
    ): Repository

}