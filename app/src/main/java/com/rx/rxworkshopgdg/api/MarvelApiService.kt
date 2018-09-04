package com.rx.rxworkshopgdg.api

import com.interview.kotlin.interview.model.Character
import com.interview.kotlin.interview.model.Comic
import com.interview.kotlin.iterview.api.MarvelApi
import com.rx.rxworkshopgdg.BuildConfig
import com.rx.rxworkshopgdg.model.*
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Martin Cardenas on 03/09/18.
 */
class MarvelApiService(private val marvelApi: MarvelApi, private val marvelAuthenticator: MarvelAuthenticator) {

    /**
     * Fetches a list of characters
     */
    fun getCharacters(): Observable<MarvelResponse<Character>>{
        marvelAuthenticator.generate()
        return marvelApi.getCharacters(marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a Character Detail given a characterId
     */
    fun getCharacterByCharacterId(characterId: Int): Flowable<MarvelResponse<Character>> {
        marvelAuthenticator.generate()
        return marvelApi.getCharacterByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a list of Comics given a characterId
     */
    fun getComicsByCharacterId(characterId: Int): Flowable<MarvelResponse<Comic>> {
        marvelAuthenticator.generate()
        return marvelApi.getComicsByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a list of Events given a characterId
     */
    fun getEventsByCharacterId(characterId: Int): Flowable<MarvelResponse<Event>> {
        marvelAuthenticator.generate()
        return marvelApi.getEventsByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a list of Series given a characterId
     */
    fun getSeriesByCharacterId(characterId: Int): Flowable<MarvelResponse<Serie>> {
        marvelAuthenticator.generate()
        return marvelApi.getSeriesByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a list of Stories given a characterId
     */
    fun getStoriesByCharacterId(characterId: Int): Flowable<MarvelResponse<Story>> {
        marvelAuthenticator.generate()
        return marvelApi.getStoriesByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a Comic Detail given a comicId
     */
    fun getComicByComicId(comicId: Int): Flowable<MarvelResponse<Comic>> {
        marvelAuthenticator.generate()
        return marvelApi.getComicByComicId(comicId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a Creator Detail given a creatorId
     */
    fun getCreatorByCreatorId(creatorId: Int): Flowable<MarvelResponse<Creator>> {
        marvelAuthenticator.generate()
        return marvelApi.getCreatorByCreatorId(creatorId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches an Event Detail given an eventId
     */
    fun getEventsByEventId(eventId: Int): Flowable<MarvelResponse<Event>> {
        marvelAuthenticator.generate()
        return marvelApi.getEventsByEventId(eventId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a Series Detail given a seriesId
     */
    fun getSeriesBySeriesId(seriesId: Int): Flowable<MarvelResponse<Serie>> {
        marvelAuthenticator.generate()
        return marvelApi.getSeriesBySeriesId(seriesId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a Story Detail given a storyId
     */
    fun getStoryByStoryId(storyId: Int): Flowable<MarvelResponse<Comic>> {
        marvelAuthenticator.generate()
        return marvelApi.getStoryByStoryId(storyId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

}