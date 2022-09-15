package com.example.retrofitwithhilt.di

import com.example.retrofitwithhilt.domain.use_case.FactUseCase
import com.example.retrofitwithhilt.domain.use_case.FactUseCaseImpl
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
    abstract fun bindFactsUseCaseWithParams(
        factsUseCaseImpl: FactUseCaseImpl,
    ): FactUseCase

}