package com.rx.rxworkshopgdg.model


data class Event(
        var id: Int?,
        var title: String?,
        var description: String?,
        var resourceURI: String?,
        var urls: List<Url?>?,
        var modified: String?,
        var start: String?,
        var end: String?,
        var thumbnail: Thumbnail?,
        var creators: Creators?,
        var characters: Characters?,
        var stories: Stories?,
        var comics: Comics?,
        var series: Series?,
        var next: Next?,
        var previous: Previous?
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


    data class Previous(
            var resourceURI: String?,
            var name: String?
    )


    data class Next(
            var resourceURI: String?,
            var name: String?
    )


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
}