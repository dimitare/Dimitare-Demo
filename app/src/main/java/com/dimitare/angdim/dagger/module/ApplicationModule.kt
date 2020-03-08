package com.dimitare.angdim.dagger.module

import android.app.Application
import android.content.Context
import com.dimitare.angdim.CVApplication
import com.dimitare.angdim.activities.ActivityBuilderModule
import com.dimitare.angdim.dagger.qualifier.ApplicationContext
import com.dimitare.angdim.services.RetrofitModule
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, RetrofitModule::class]
)
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: CVApplication): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}