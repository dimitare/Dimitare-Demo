package com.dimitare.angdim.fragments

import androidx.lifecycle.ViewModel
import com.dimitare.angdim.dagger.qualifier.FragmentScope
import com.dimitare.angdim.fragments.viewmodels.BaseViewFragmentViewModel
import com.dimitare.angdim.fragments.viewmodels.factory.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

@FragmentScope
class FragmentViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseViewFragmentViewModel>,
            @JvmSuppressWildcards Provider<BaseViewFragmentViewModel>>
) : BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)