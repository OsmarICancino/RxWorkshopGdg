package com.rx.rxworkshopgdg.di

import com.interview.kotlin.iterview.api.MarvelApi
import com.rx.rxworkshopgdg.BuildConfig
import com.rx.rxworkshopgdg.api.MarvelApiService
import com.rx.rxworkshopgdg.api.MarvelAuthenticator
import dagger.Module

import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    fun providesMarvelApiService(marvelApi: MarvelApi, marvelAuthenticator: MarvelAuthenticator): MarvelApiService {
        return MarvelApiService(marvelApi, marvelAuthenticator)
    }

    @Provides
    @Reusable
    @JvmStatic
    fun providesMarvelAuthenticator(): MarvelAuthenticator {
        return MarvelAuthenticator()
    }

    @Provides
    @Reusable
    @JvmStatic
    fun providesMarvelApi(retrofit: Retrofit): MarvelApi {
        return retrofit.create(MarvelApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun providesRetrofit(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

}
