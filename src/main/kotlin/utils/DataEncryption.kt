package com.example.utils

import com.example.utils.Constant.TRANSFORMATION
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import javax.crypto.Cipher


object DataEncryption {

    fun encrypt(
        data : String,
        generatedPublicKey : String
    ) : String? {
        return try {
            val publicKeyBytes = Base64.getDecoder().decode(generatedPublicKey)
            val publicKeySpec = X509EncodedKeySpec(publicKeyBytes)

            val keyFactory = KeyFactory.getInstance("RSA")
            val publicKey = keyFactory.generatePublic(publicKeySpec)

            val cipher = Cipher.getInstance(TRANSFORMATION)
            cipher.init(Cipher.ENCRYPT_MODE, publicKey)

            val result = cipher.doFinal(data.toByteArray())
            Base64.getEncoder().encodeToString(result)

        } catch (e : Exception){
            null
        }
    }

}