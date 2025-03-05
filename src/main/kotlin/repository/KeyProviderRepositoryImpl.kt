package com.example.repository

import com.example.domain.model.Keys
import com.example.utils.Constant.secondKey
import com.example.utils.Constant.firstKey
import com.example.utils.DataEncryption
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class KeyProviderRepositoryImpl : KeyProviderRepository {
    override suspend fun generateKey(keyPublic: String): String? {
        return withContext(Dispatchers.IO) {
            DataEncryption.encrypt(
                data = Json.encodeToString(
                    Keys(
                        firstKey = firstKey,
                        secondKey = secondKey
                    )
                ),
                generatedPublicKey = keyPublic
            )
        }
    }

}