package com.dimitare.angdim

import android.content.Context
import androidx.multidex.MultiDex
import com.dimitare.angdim.dagger.DaggerAppComponent
import dagger.android.DaggerApplication

class CVApplication : DaggerApplication() {
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        MultiDex.install(this)
    }

    private val applicationInjector = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector
}