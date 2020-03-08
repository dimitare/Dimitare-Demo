package com.dimitare.angdim.services

import androidx.lifecycle.MutableLiveData
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.services.remote.RemoteResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class DemoServiceImpl(val mDemoDataSource: DemoDataSource): CoroutineScope,  DemoService {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override suspend fun fetchResumeById(userId: String) {
        userResumeFromRemoteDataSource(userId)
    }

    private suspend fun userResumeFromRemoteDataSource(userId: String) {
        mDemoDataSource.fetchUserResume(userId)
    }

    override fun observeResume(): MutableLiveData<RemoteResource<ResumeResponse, ResumeError>> {
        return mDemoDataSource.observeUserResume()
    }
}