package com.rx.rxworkshopgdg.api

import com.rx.rxworkshopgdg.BuildConfig
import com.rx.rxworkshopgdg.utils.md5
import java.util.*

/**
 * Created by Martin Cardenas on 04/09/18.
 */
class MarvelAuthenticator {

    var ts :Long = 1
    var publicApiKey :String = BuildConfig.PUBLIC_KEY
    var privateApiKey :String = BuildConfig.PRIVATE_KEY
    var hash :String = ""

    fun generate() {
//        ts = Date().time
//        hash = ("" + ts + privateApiKey + publicApiKey).md5()
        ts = 1
        hash = BuildConfig.HASH_MD5_DIGEST
    }

}