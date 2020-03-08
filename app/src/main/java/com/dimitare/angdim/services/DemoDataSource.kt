package com.dimitare.angdim.services

import androidx.lifecycle.MutableLiveData
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.services.remote.RemoteResource

interface DemoDataSource {
    fun observeUserResume(): MutableLiveData<RemoteResource<ResumeResponse, ResumeError>>
    suspend fun fetchUserResume(userId: String): Unit?
}