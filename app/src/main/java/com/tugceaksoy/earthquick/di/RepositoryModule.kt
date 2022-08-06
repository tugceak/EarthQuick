package com.tugceaksoy.earthquick.di

import com.tugceaksoy.earthquick.data.repository.EarthQuakesRepository
import com.tugceaksoy.earthquick.data.repository.EarthQuakesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindRocketsRepository(repository: EarthQuakesRepositoryImpl) : EarthQuakesRepository
}