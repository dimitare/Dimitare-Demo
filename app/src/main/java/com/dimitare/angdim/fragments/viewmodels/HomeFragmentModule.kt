package com.dimitare.angdim.fragments.viewmodels

import androidx.fragment.app.Fragment
import com.dimitare.angdim.dagger.keys.FragmentViewModelKey
import com.dimitare.angdim.dagger.qualifier.FragmentScope
import com.dimitare.angdim.fragments.BaseViewModelFragmentModule
import com.dimitare.angdim.fragments.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseViewModelFragmentModule::class])
abstract class HomeFragmentModule: BaseViewModel() {
    @Binds
    @FragmentScope
    abstract fun bindFragment(fragment: HomeFragment): Fragment


    @Binds
    @IntoMap
    @FragmentViewModelKey(HomeFragmentViewModel::class)
    @FragmentScope
    abstract fun bindViewModel(viewModel: HomeFragmentViewModel): BaseViewFragmentViewModel
}