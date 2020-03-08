package com.dimitare.angdim.activities.main

import androidx.appcompat.app.AppCompatActivity
import com.dimitare.angdim.MainActivity
import com.dimitare.angdim.activities.BaseActivityModule
import com.dimitare.angdim.activities.BaseViewActivityViewModel
import com.dimitare.angdim.dagger.keys.ActivityViewModelKey
import com.dimitare.angdim.dagger.qualifier.ActivityScope
import com.dimitare.angdim.fragments.FragmentBuilderModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseActivityModule::class, FragmentBuilderModule::class])
abstract class MainActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(MainActivityViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: MainActivityViewModel): BaseViewActivityViewModel
}