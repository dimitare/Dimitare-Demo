package com.dimitare.angdim.fragments

import com.dimitare.angdim.dagger.qualifier.FragmentScope
import com.dimitare.angdim.fragments.viewmodels.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @FragmentScope
    abstract fun contributeHomeFragment(): HomeFragment
}