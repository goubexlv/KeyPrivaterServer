package com.example.domain.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseApi(
    val success : Boolean,
    val message : String
)
