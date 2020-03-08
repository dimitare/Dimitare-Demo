package com.dimitare.angdim.fragments

import androidx.lifecycle.ViewModelProvider
import com.dimitare.angdim.dagger.qualifier.FragmentContext
import com.dimitare.angdim.dagger.qualifier.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class BaseViewModelFragmentModule {
    @Binds
    @FragmentScope
    @FragmentContext
    abstract fun bindViewModelFactory(viewModelFactory: FragmentViewModelFactory): ViewModelProvider.Factory
}