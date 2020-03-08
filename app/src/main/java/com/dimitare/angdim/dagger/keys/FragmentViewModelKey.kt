package com.dimitare.angdim.dagger.keys

import com.dimitare.angdim.fragments.viewmodels.BaseViewFragmentViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
@MustBeDocumented
annotation class FragmentViewModelKey(val value: KClass<out BaseViewFragmentViewModel>)