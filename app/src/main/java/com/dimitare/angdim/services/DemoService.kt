package com.dimitare.angdim.services

import androidx.lifecycle.MutableLiveData
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.services.remote.RemoteResource

interface DemoService {
    fun observeResume(): MutableLiveData<RemoteResource<ResumeResponse, ResumeError>>
    suspend fun fetchResumeById(userId: String)
}