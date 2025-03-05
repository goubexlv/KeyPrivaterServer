package com.example.routes

import com.example.domain.model.Endpoint
import com.example.domain.model.Keys
import com.example.domain.request.RequestApi
import com.example.domain.response.ResponseApi
import com.example.repository.KeyProviderRepository
import com.example.utils.DataEncryption
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import kotlinx.serialization.json.Json

fun Route.KeyProvider(keyProvider : KeyProviderRepository){

    post(Endpoint.KeyProvider.path){

        try {
            val publicKey = call.receive<RequestApi>()
            if (publicKey != null){

                val encryptedData = keyProvider.generateKey(publicKey.publicKey)
                if(encryptedData != null){
                    call.respond(
                        message = ResponseApi(
                            success = true,
                            message = encryptedData
                        ),
                        status = HttpStatusCode.OK
                    )

                } else {
                    call.respond(
                        message = "la cle encrypter es null",
                        status = HttpStatusCode.BadRequest
                    )
                }

            }else {
                call.respond(
                    message = "la cle public es null",
                    status = HttpStatusCode.BadRequest
                )
            }

        } catch (e : Exception){
            call.respond(
                message = "erreur $e",
                status = HttpStatusCode.NotFound
            )
        }
    }


}