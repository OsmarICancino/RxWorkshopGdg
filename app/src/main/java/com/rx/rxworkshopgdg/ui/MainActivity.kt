package com.rx.rxworkshopgdg.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.rx.rxworkshopgdg.model.Comic
import com.rx.rxworkshopgdg.R
import com.rx.rxworkshopgdg.api.MarvelApiService
import com.rx.rxworkshopgdg.di.DaggerNetworkComponent
import com.rx.rxworkshopgdg.model.MarvelResponse
import com.rx.rxworkshopgdg.model.Character
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.functions.Predicate
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var marvelApiService: MarvelApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inject dependencies
        DaggerNetworkComponent.create().inject(this)
        button_go.setOnClickListener({ v: View? ->
            just()
            justWithArray()
            toObservable()
            take()
            zip2()
            zip3()
            map()
            sorted()
            concatMap()
            flatMapIterable()
            filter()
            startWith()
            reduce()
            getPriceSumOfComicsOfCharacterWithShorterName()
        })
    }

    val hello: String = "Hello!!!"
    val decades: IntArray = intArrayOf(70, 30, 10, 40, 90, 80, 60, 20, 50)
    val primeNumbers: IntArray = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199)
    val names: Array<String> = arrayOf("Diana", "John", "David", "Mike", "Alex", "Susan")
    val lastNames: Array<String> = arrayOf("Smith", "Doe", "Brown", "Wilson", "Johnson", "Miller", "Williams", "Taylor")

    fun just() {
        Observable.just(hello)
                .subscribe(
                { t: String? -> Log.d("just::onNext", t) },
                { t: Throwable? -> Log.d("just::onError", t?.message) },
                { Log.d("just::onComplete", "onComplete") }
        )
    }

    fun justWithArray() {
        Observable.just(primeNumbers)
                .subscribe(
                { t: IntArray? ->  Log.d("justWithArray::onNext", t.toString()) },
                { t: Throwable? -> Log.d("justWithArray::onError", t?.message) },
                { Log.d("justWithArrayonComplete", "onComplete") }
        )
    }

    fun toObservable() {
        // Kotlin extension
        names.toObservable()
                .subscribe(
                { t: String? -> Log.d("toObservable::onNext", t) },
                { t: Throwable? -> Log.d("toObservable::onError", t?.message) },
                { Log.d("toObservable", "onComplete") }
        )
    }

    fun take() {
        names.toObservable()
                .take(2)
                .subscribe(
                        { t: String? -> Log.d("take::onNext", t) },
                        { t: Throwable? -> Log.d("take::onError", t?.message) },
                        { Log.d("take::onComplete", "onComplete") })
    }

    fun zip2() {
        Observable.zip(
                primeNumbers.toObservable(),
                lastNames.toObservable(),
                BiFunction { p: Int, l: String -> (" $p $l") })
                .subscribe(
                        { t: String? -> Log.d("zip2::onNext", t) },
                        { th: Throwable? -> Log.d("zip2::onError", th?.message) },
                        { Log.d("zip2::onComplete", "onComplete") })
    }

    fun zip3() {
        Observable.zip(
                names.toObservable(),
                decades.toObservable(),
                lastNames.toObservable(),
                Function3 { n: String, d: Int, l: String -> " $n $d $l" })
                .subscribe(
                        { t: String? -> Log.d("zip3::onNext", t) },
                        { th: Throwable? -> Log.d("zip3::onError", th?.message) },
                        { Log.d("zip3::onComplete", "onComplete") })
    }

    fun map() {
        decades.toObservable()
                .map { t: Int -> " *$t* " }
                .subscribe({ t: String? -> Log.d("map::onNext", t) },
                        { th: Throwable? -> Log.d("map::onError", th?.message) },
                        { -> Log.d("map::onComplete", "onComplete") })
    }

    fun sorted() {
        decades.toObservable()
                .sorted({o1: Int?, o2: Int? -> ((o2?:0)-(o1?:0)) })
                .subscribe({ t: Int -> Log.d("sorted::onNext", "$t") },
                        { th: Throwable? -> Log.d("sorted::onError", th?.message) },
                        { Log.d("sorted::onComplete", "onComplete") })
    }

    fun concatMap() {
        Observable.just(hello)
                .concatMap { names.toObservable() }
                .subscribe({ t: String? -> Log.d("concatMap::onNext", t) },
                        { th: Throwable? -> Log.d("concatMap::onError", th?.message) },
                        { Log.d("concatMap::onComplete", "onComplete") })
    }

    fun flatMapIterable() {
        Observable.just(decades)
                .flatMapIterable({t: IntArray -> t.asIterable() })
                .subscribe({ t: Int? -> Log.d("flatMapIterable::onNext", "$t") },
                        { th: Throwable? -> Log.d("flatMapIterable", "ERROR: " + th?.message) },
                        { -> Log.d("flatMapIterable", "onComplete") })
    }

    fun filter() {
        lastNames.toObservable()
                .filter(Predicate { t -> t.length > 5 })
                .subscribe({ t: String? -> Log.d("filter::onNext", t) },
                        { th: Throwable? -> Log.d("filter::onError", th?.message) },
                        { Log.d("filter::onComplete", "onComplete") })
    }

    fun startWith() {
        Observable.just(hello)
                .startWith(" GDG ")
                .subscribe({ t: String? -> Log.d("startWith::onNext", t) },
                        { th: Throwable? -> Log.d("startWith::onError", th?.message) },
                        { Log.d("startWith::onComplete", "onComplete") })
    }

    fun reduce() {
        decades.toObservable()
                .reduce { t1: Int, t2: Int -> t1 + t2 }
                .subscribe({ t: Int? -> Log.d("reduce::onNext", "$t") },
                        { th: Throwable? -> Log.d("reduce::onError", th?.message) },
                        { Log.d("reduce::onComplete", "onComplete") })
    }

    fun getComics() {
        marvelApiService.getComicsByCharacterId(1011244)
                .subscribe({t -> Log.d("getComics" , t.data?.results?.get(0)?.title ?: "null response") }
                , {t -> Log.e("getComics", "ERROR: " + t.message)
                t.printStackTrace()})
    }

    fun getCharacters() {
        marvelApiService.getCharacters()
                .subscribe({t -> Log.d("getCharacters", "Results: " + t.data?.count)  }
                        , {t ->  Log.e("getCharacters", "ERROR: " + t.message) }
                        , {Log.d("getCharacters", "onComplete") })
    }

    fun getPriceSumOfComicsOfCharacterWithShorterName() {
        marvelApiService.getCharacters()
                .flatMapIterable { t: MarvelResponse<Character> -> t.data?.results }
                .sorted({ o1: Character, o2: Character -> ( (o1.name?.length?:0) - (o2.name?.length?:0) ) })
                .take(1)
                .map { it.id }
                .flatMap { t -> marvelApiService.getComicsByCharacterId(t) }
                .flatMapIterable {t: MarvelResponse<Comic> -> t.data?.results }
                .flatMapIterable { t: Comic -> t.prices }
                .filter(Predicate { t -> t.type?.contentEquals("printPrice")?:false})
                .map { t: Comic.PricesBean -> t.price }
                .reduce(BiFunction{t1, t2 -> t1 + t2 })
                .subscribe({ it ->
                    Log.d("getCharacterList", "result arrived sum=$it" )
                }, { t -> Log.e("API ERROR", t.message) })
    }

}
