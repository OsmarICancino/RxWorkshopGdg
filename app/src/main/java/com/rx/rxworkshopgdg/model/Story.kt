package com.rx.rxworkshopgdg.model


data class Story(
        var id: Int?,
        var title: String?,
        var description: String?,
        var resourceURI: String?,
        var type: String?,
        var modified: String?,
        var thumbnail: Any?,
        var creators: Creators?,
        var characters: Characters?,
        var series: Series?,
        var comics: Comics?,
        var events: Events?,
        var originalIssue: OriginalIssue?
) {

    data class Characters(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Any?>?,
            var returned: Int?
    )


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


    data class Creators(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Any?>?,
            var returned: Int?
    )


    data class Events(
            var available: Int?,
            var collectionURI: String?,
            var items: List<Any?>?,
            var returned: Int?
    )


    data class OriginalIssue(
            var resourceURI: String?,
            var name: String?
    )
}