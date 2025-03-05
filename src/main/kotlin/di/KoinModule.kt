package com.example.di

import com.example.repository.KeyProviderRepository
import com.example.repository.KeyProviderRepositoryImpl
import org.koin.dsl.module

val KoinModule = module {
    single<KeyProviderRepository> {
        KeyProviderRepositoryImpl()
    }

}