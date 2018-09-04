package com.rx.rxworkshopgdg.utils

import java.security.MessageDigest

/**
 * Created by Martin Cardenas on 04/09/18.
 */

fun hashString(type: String, input: String): String {
    val HEX_CHARS = "0123456789abcdef"
    val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
    val result = StringBuilder(bytes.size * 2)

    bytes.forEach {
        val i = it.toInt()
        result.append(HEX_CHARS[i shr 4 and 0x0f])
        result.append(HEX_CHARS[i and 0x0f])
    }

    return result.toString()
}


fun String.md5(): String {
    return hashString("MD5", this)
}
