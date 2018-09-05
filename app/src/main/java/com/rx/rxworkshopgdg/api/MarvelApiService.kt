package com.rx.rxworkshopgdg.api

import com.rx.rxworkshopgdg.model.Character
import com.rx.rxworkshopgdg.model.Comic
import com.rx.rxworkshopgdg.api.MarvelApi
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
    fun getCharacterByCharacterId(characterId: Int): Observable<MarvelResponse<Character>> {
        marvelAuthenticator.generate()
        return marvelApi.getCharacterByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a list of Comics given a characterId
     */
    fun getComicsByCharacterId(characterId: Int): Observable<MarvelResponse<Comic>> {
        marvelAuthenticator.generate()
        return marvelApi.getComicsByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a list of Events given a characterId
     */
    fun getEventsByCharacterId(characterId: Int): Observable<MarvelResponse<Event>> {
        marvelAuthenticator.generate()
        return marvelApi.getEventsByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a list of Series given a characterId
     */
    fun getSeriesByCharacterId(characterId: Int): Observable<MarvelResponse<Serie>> {
        marvelAuthenticator.generate()
        return marvelApi.getSeriesByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a list of Stories given a characterId
     */
    fun getStoriesByCharacterId(characterId: Int): Observable<MarvelResponse<Story>> {
        marvelAuthenticator.generate()
        return marvelApi.getStoriesByCharacterId(characterId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash, BuildConfig.LIMIT)
    }

    /**
     * Fetches a Comic Detail given a comicId
     */
    fun getComicByComicId(comicId: Int): Observable<MarvelResponse<Comic>> {
        marvelAuthenticator.generate()
        return marvelApi.getComicByComicId(comicId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a Creator Detail given a creatorId
     */
    fun getCreatorByCreatorId(creatorId: Int): Observable<MarvelResponse<Creator>> {
        marvelAuthenticator.generate()
        return marvelApi.getCreatorByCreatorId(creatorId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches an Event Detail given an eventId
     */
    fun getEventsByEventId(eventId: Int): Observable<MarvelResponse<Event>> {
        marvelAuthenticator.generate()
        return marvelApi.getEventsByEventId(eventId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a Series Detail given a seriesId
     */
    fun getSeriesBySeriesId(seriesId: Int): Observable<MarvelResponse<Serie>> {
        marvelAuthenticator.generate()
        return marvelApi.getSeriesBySeriesId(seriesId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

    /**
     * Fetches a Story Detail given a storyId
     */
    fun getStoryByStoryId(storyId: Int): Observable<MarvelResponse<Comic>> {
        marvelAuthenticator.generate()
        return marvelApi.getStoryByStoryId(storyId, marvelAuthenticator.ts, marvelAuthenticator.publicApiKey, marvelAuthenticator.hash)
    }

}