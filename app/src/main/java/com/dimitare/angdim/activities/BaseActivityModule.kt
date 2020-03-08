package com.dimitare.angdim.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dimitare.angdim.dagger.qualifier.ActivityContext
import com.dimitare.angdim.dagger.qualifier.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule {
    @Binds
    @ActivityScope
    @ActivityContext
    abstract fun bindActivityContext(activity: AppCompatActivity): Context

    @Binds
    @ActivityScope
    @ActivityContext
    abstract fun bindViewModelFactory(viewModelFactory: ActivityViewModelFactory): ViewModelProvider.Factory
}