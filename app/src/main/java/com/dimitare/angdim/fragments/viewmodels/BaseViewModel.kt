package com.dimitare.angdim.fragments.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    protected lateinit var application: Application
}
