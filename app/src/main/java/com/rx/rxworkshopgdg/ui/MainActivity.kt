package com.rx.rxworkshopgdg.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.rx.rxworkshopgdg.R
import com.rx.rxworkshopgdg.api.MarvelApiService
import com.rx.rxworkshopgdg.di.DaggerNetworkComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var marvelApiService: MarvelApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inject dependencies
        DaggerNetworkComponent.create().inject(this)
        button_go.setOnClickListener({ v: View? ->
            marvelApiService.getCharacters().subscribe({it ->
                Log.d("MARTIN", "result arrived") }, {
                t -> Log.e("API ERROR",  t.message) })
        })


    }
}
