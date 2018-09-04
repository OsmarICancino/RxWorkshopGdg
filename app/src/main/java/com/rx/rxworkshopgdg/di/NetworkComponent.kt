package com.rx.rxworkshopgdg.di

import com.rx.rxworkshopgdg.ui.MainActivity
import dagger.Component

/**
 * Created by Martin Cardenas on 03/09/18.
 */
@Component(modules = [(NetworkModule::class)])
interface NetworkComponent {

    fun inject(activity: MainActivity)

}