package com.example.retrofitwithhilt.di

import com.example.retrofitwithhilt.domain.use_case.FactUseCaseImpl
import com.example.retrofitwithhilt.domain.use_case.FactUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindFactsUseCase(
        factsUseCaseImpl: FactUseCaseImpl,
    ): FactUseCase
}