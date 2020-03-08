package com.dimitare.angdim.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.dimitare.angdim.dagger.qualifier.FragmentContext
import com.dimitare.angdim.fragments.viewmodels.BaseViewFragmentViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import androidx.fragment.app.viewModels as viewModelsInternal

abstract class BaseDaggerFragment<VM : BaseViewFragmentViewModel> : Fragment(), HasAndroidInjector {
    @Inject
    protected lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @FragmentContext
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract val mViewModel: VM

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @Suppress("UNUSED_PARAMETER")
    protected inline fun <reified VM : ViewModel> viewModels(
        ownerProducer: () -> ViewModelStoreOwner = { this }
    ) = viewModelsInternal<VM> { viewModelFactory }
}
