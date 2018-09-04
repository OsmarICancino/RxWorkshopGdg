package com.rx.rxworkshopgdg.model


data class Serie(
        var id: Int?,
        var title: String?,
        var description: Any?,
        var resourceURI: String?,
        var urls: List<Url?>?,
        var startYear: Int?,
        var endYear: Int?,
        var rating: String?,
        var type: String?,
        var modified: String?,
        var thumbnail: Thumbnail?,
        var creators: Creators?,
        var characters: Characters?,
        var stories: Stories?,
        var comics: Comics?,
        var events: Events?,
        var next: Any?,
        var previous: Any?
) {

    data class Characters(
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


    data class Creators(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Item?>?,
            var returned: Int?
    ) {

        data class Item(
                var resourceURI: String?,
                var name: String?,
                var role: String?
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


    data class Url(
            var type: String?,
            var url: String?
    )


    data class Thumbnail(
            var path: String?,
            var extension: String?
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