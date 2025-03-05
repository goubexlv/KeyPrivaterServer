package com.example.plugins

import com.example.repository.KeyProviderRepository
import com.example.routes.KeyProvider
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        val keyProvide : KeyProviderRepository by application.inject()
        KeyProvider(keyProvide)
    }
}
