package com.example.retrofitwithhilt.di

import com.example.retrofitwithhilt.data.repository.FactsRepository
import com.example.retrofitwithhilt.domain.repository.Repository
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
    abstract fun bindRepository(
        factsRepository: FactsRepository,
    ): Repository
}