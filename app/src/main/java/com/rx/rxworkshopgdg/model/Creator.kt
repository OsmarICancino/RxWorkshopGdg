package com.rx.rxworkshopgdg.model

/**
 * Created by Martin Cardenas on 03/09/18.
 */
data class Creator(
        var id: Int?,
        var firstName: String?,
        var middleName: String?,
        var lastName: String?,
        var suffix: String?,
        var fullName: String?,
        var modified: String?,
        var thumbnail: Thumbnail?,
        var resourceURI: String?,
        var comics: Comics?,
        var series: Series?,
        var stories: Stories?,
        var events: Events?,
        var urls: List<Url?>?
) {

    data class Series(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Item?>?,
            var returned: Int?
    ) {

        data class Item(
                var resourceURI: String?,
                var name: String?
        )
    }


    data class Stories(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Item?>?,
            var returned: Int?
    ) {

        data class Item(
                var resourceURI: String?,
                var name: String?,
                var type: String?
        )
    }


    data class Thumbnail(
            var path: String?,
            var extension: String?
    )


    data class Url(
            var type: String?,
            var url: String?
    )


    data class Comics(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Item?>?,
            var returned: Int?
    ) {

        data class Item(
                var resourceURI: String?,
                var name: String?
        )
    }


    data class Events(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Any?>?,
            var returned: Int?
    )
}