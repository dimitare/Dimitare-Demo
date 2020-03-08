package com.dimitare.angdim.fragments.viewmodels

abstract class BaseViewFragmentViewModel: BaseViewModel(){
    fun start() {
        startViewModel()
    }

    fun stop() {
        stopViewModel()
    }

    internal open fun startViewModel() {
        unsubscribe()
        subscribe()
    }

    internal open fun stopViewModel() {
        unsubscribe()
    }

    abstract fun unsubscribe()
    abstract fun subscribe()
}