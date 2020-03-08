package com.dimitare.angdim.activities

import androidx.lifecycle.ViewModel
import com.dimitare.angdim.dagger.qualifier.ActivityScope
import com.dimitare.angdim.fragments.viewmodels.factory.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ActivityViewModelFactory @Inject constructor(
    creators: Map<Class<out BaseViewActivityViewModel>,
            @JvmSuppressWildcards Provider<BaseViewActivityViewModel>>
) : BaseViewModelFactory(creators as Map<Class<out ViewModel>, Provider<ViewModel>>)