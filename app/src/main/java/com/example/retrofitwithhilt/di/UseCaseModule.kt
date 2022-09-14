package com.example.retrofitwithhilt.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
//
//    @Binds
//    @Singleton
//    abstract fun bindFactsUseCase(
//        factsUseCaseImpl: FactUseCaseImpl,
//    ): FactUseCase
}