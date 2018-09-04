package com.rx.rxworkshopgdg.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.rx.rxworkshopgdg.R
import com.rx.rxworkshopgdg.api.MarvelApiService
import com.rx.rxworkshopgdg.di.DaggerNetworkComponent
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
            marvelApiService.getCharacters().subscribe({ it ->
                Log.d("MARTIN", "result arrived")
            }, { t -> Log.e("API ERROR", t.message) })
        })
    }

    val hello: String = "Hello!!!"
    val decades: IntArray = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90)
    val primeNumbers: IntArray = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199)
    val names: Array<String> = arrayOf("Diana", "John", "David", "Mike", "Alex", "Susan")
    val lastNames: Array<String> = arrayOf("Smith", "Doe", "Brown", "Wilson", "Johnson", "Miller", "Williams", "Taylor")

    fun just() {
        Observable.just(hello).subscribe(
                { t: String? -> Log.d("just::onNext", t) },
                { t: Throwable? -> Log.d("just::onError", t?.message) },
                { -> Log.d("just::onComplete", "onComplete") }
        )
    }

    fun fromArray() {
        // Kotlin extension
        names.toObservable().subscribe(
                { t: String? -> Log.d("fromArray::onNext", t) },
                { t: Throwable? -> Log.d("fromArray::onError", t?.message) },
                { -> Log.d("fromArray::onComplete", "onComplete") }
        )
    }

    fun zip2() {
        Observable.zip(
                primeNumbers.toObservable(),
                lastNames.toObservable(),
                BiFunction { p: Int, l: String -> (" $p $l") })
                .subscribe(
                        { t: String? -> Log.d("zip2::onNext", t) },
                        { th: Throwable? -> Log.d("zip2::onError", th?.message) },
                        { -> Log.d("zip2::onComplete", "onComplete") })
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
                        { -> Log.d("zip3::onComplete", "onComplete") })
    }

    fun map() {
        decades.toObservable().map { t: Int -> " *$t* " }
                .subscribe({ t: String? -> Log.d("map::onNext", t) },
                        { th: Throwable? -> Log.d("map::onError", th?.message) },
                        { -> Log.d("map::onComplete", "onComplete") })
    }

    fun filter() {
        lastNames.toObservable()
                .filter(Predicate { t -> t.length > 5 })
                .subscribe({ t: String? -> Log.d("filter::onNext", t) },
                        { th: Throwable? -> Log.d("filter::onError", th?.message) },
                        { -> Log.d("filter::onComplete", "onComplete") })
    }


    fun startWith() {
        Observable.just(hello)
                .startWith(" GDG ")
                .subscribe({ t: String? -> Log.d("startWith::onNext", t) },
                        { th: Throwable? -> Log.d("startWith::onError", th?.message) },
                        { -> Log.d("startWith::onComplete", "onComplete") })
    }
}
