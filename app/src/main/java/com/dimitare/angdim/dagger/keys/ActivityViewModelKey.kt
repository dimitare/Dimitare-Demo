package com.dimitare.angdim.dagger.keys

import com.dimitare.angdim.activities.BaseViewActivityViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
@MustBeDocumented
annotation class ActivityViewModelKey(val value: KClass<out BaseViewActivityViewModel>)