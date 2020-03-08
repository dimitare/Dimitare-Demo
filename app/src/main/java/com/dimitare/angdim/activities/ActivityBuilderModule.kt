package com.dimitare.angdim.activities

import android.app.Application
import android.content.Context
import com.dimitare.angdim.MainActivity
import com.dimitare.angdim.activities.main.MainActivityModule
import com.dimitare.angdim.dagger.qualifier.ActivityScope
import com.dimitare.angdim.services.DemoRemoteRepositoryModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class, DemoRemoteRepositoryModule::class])
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity


    @Binds
    @Singleton
    abstract fun bindApplicationContext(application: Application): Context
}