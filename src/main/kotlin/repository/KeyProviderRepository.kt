package com.example.repository

interface KeyProviderRepository {

    suspend fun generateKey(keyPublic : String) : String?
}