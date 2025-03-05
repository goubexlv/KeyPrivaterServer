package com.example.domain.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestApi(
    val publicKey : String
)
