package com.example.domain.model

sealed class Endpoint(val path: String) {
    object Root: Endpoint(path = "/")
    object KeyProvider: Endpoint(path = "/keyprovider")

}