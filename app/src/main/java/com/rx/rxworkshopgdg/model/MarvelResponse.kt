package com.rx.rxworkshopgdg.model

/**
 * Created by Martin Cardenas on 03/09/18.
 */
data class MarvelResponse<T> constructor(var code: Int = 0,
                                         var status: String? = null,
                                         var copyright: String? = null,
                                         var attributionText: String? = null,
                                         var attributionHTML: String? = null,
                                         var etag: String? = null,
                                         var data: DataBean<T>? = null) {

    class DataBean<T> {
        var offset: Int = 0
        var limit: Int = 0
        var total: Int = 0
        var count: Int = 0
        var results: List<T>? = null
    }

}


