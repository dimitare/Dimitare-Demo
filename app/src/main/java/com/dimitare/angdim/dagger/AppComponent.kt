package com.dimitare.angdim.dagger

import androidx.core.view.KeyEventDispatcher
import com.dimitare.angdim.CVApplication
import com.dimitare.angdim.dagger.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by @Dimitare on 03/07/20.
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent : AndroidInjector<CVApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CVApplication): Builder

        fun build(): AppComponent
    }
}