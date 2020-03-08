package com.dimitare.angdim.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dimitare.angdim.dagger.qualifier.ActivityContext
import com.dimitare.angdim.fragments.viewmodels.BaseViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(), HasAndroidInjector {@Inject
    protected lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @ActivityContext
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}