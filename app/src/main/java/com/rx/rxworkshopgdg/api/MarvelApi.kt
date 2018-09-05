package com.rx.rxworkshopgdg.api

import com.rx.rxworkshopgdg.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author by hugo on 5/24/17.
 */
interface MarvelApi {

    /**
     * Fetches a list of characters
     */
    //https://gateway.marvel.com/v1/public/characters?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("characters?orderBy=-modified&nameStartsWith=th")
    fun getCharacters(
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("limit") limit: Int
            ): Observable<MarvelResponse<Character>>

    /**
     * Fetches a Character Detail given a characterId
     */
    //https://gateway.marvel.com/v1/public/characters/1009148?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("characters/{characterId}")
    fun getCharacterByCharacterId(
            @Path("characterId") characterId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String): Observable<MarvelResponse<Character>>

    /**
     * Fetches a list of Comics given a characterId
     */
    //https://gateway.marvel.com/v1/public/characters/1010338/comics?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("characters/{characterId}/comics")
    fun getComicsByCharacterId(
            @Path("characterId") characterId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("limit") limit: Int): Observable<MarvelResponse<Comic>>

    /**
     * Fetches a list of Events given a characterId
     */
    //https://gateway.marvel.com/v1/public/characters/1010338/events?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("characters/{characterId}/events?")
    fun getEventsByCharacterId(
            @Path("characterId") characterId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("limit") limit: Int): Observable<MarvelResponse<Event>>

    /**
     * Fetches a list of Series given a characterId
     */
    //https://gateway.marvel.com/v1/public/characters/1010338/series?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("characters/{characterId}/series?")
    fun getSeriesByCharacterId(
            @Path("characterId") characterId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("limit") limit: Int): Observable<MarvelResponse<Serie>>

    /**
     * Fetches a list of Stories given a characterId
     */
    //https://gateway.marvel.com/v1/public/characters/1010338/stories?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("characters/{characterId}/stories?")
    fun getStoriesByCharacterId(
            @Path("characterId") characterId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("limit") limit: Int): Observable<MarvelResponse<Story>>

    /**
     * Fetches a Comic Detail given a comicId
     */
    //https://gateway.marvel.com/v1/public/comics/61431?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("comics/{comicId}?")
    fun getComicByComicId(
            @Path("comicId") comicId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String): Observable<MarvelResponse<Comic>>

    /**
     * Fetches a Creator Detail given a creatorId
     */
    //https://gateway.marvel.com/v1/public/creator/61431?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("creators/{creatorId}?")
    fun getCreatorByCreatorId(
            @Path("creatorId") creatorId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String): Observable<MarvelResponse<Creator>>

    /**
     * Fetches an Event Detail given an eventId
     */
    //https://gateway.marvel.com/v1/public/events/61431?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("events/{eventId}?")
    fun getEventsByEventId(
            @Path("eventId") eventId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String): Observable<MarvelResponse<Event>>

    /**
     * Fetches a Series Detail given a seriesId
     */
    //https://gateway.marvel.com/v1/public/comics/61431?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("series/{seriesId}?")
    fun getSeriesBySeriesId(
            @Path("seriesId") seriesId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String): Observable<MarvelResponse<Serie>>

    /**
     * Fetches a Story Detail given a storyId
     */
    //https://gateway.marvel.com/v1/public/comics/61431?ts=1&apikey=fb9cf622de091ac20051e62a51c81149&hash=b68e7aeef8e1843eb3b2958aa737c743
    @GET("stories/{storyId}?")
    fun getStoryByStoryId(
            @Path("storyId") storyId: Int,
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String): Observable<MarvelResponse<Comic>>

}