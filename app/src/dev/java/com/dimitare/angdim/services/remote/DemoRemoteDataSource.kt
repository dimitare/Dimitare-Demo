package com.dimitare.angdim.services.remote

import androidx.lifecycle.MutableLiveData
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.services.DemoDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemoRemoteDataSource(
    val mDemoService: DemoServiceApi,
    private val mIoDispatcher: CoroutineDispatcher = Dispatchers.IO
) : DemoDataSource {
    val mResume = MutableLiveData<RemoteResource<ResumeResponse, ResumeError>>()

    override fun observeUserResume(): MutableLiveData<RemoteResource<ResumeResponse, ResumeError>> =
        mResume

    override suspend fun fetchUserResume(userId: String): Unit? =
        withContext(mIoDispatcher) {
            val result =
                mDemoService.fetchUserProfile(userId)
            result.enqueue(object : Callback<ResumeResponse> {
                override fun onFailure(call: Call<ResumeResponse>, t: Throwable) {
                    // TODO - format the error type and message
                    mResume.postValue(
                        RemoteResource.Error(
                            errorData = ResumeError(message = "Some internal error occurred"),
                            errorMessage = "Some internal error occurred"
                        )
                    )
                }

                override fun onResponse(
                    call: Call<ResumeResponse>,
                    response: Response<ResumeResponse>
                ) {
                    if (response.isSuccessful) {
                        mResume.postValue(RemoteResource.Success(data = response.body()))
                    } else {
                        mResume.postValue(RemoteResource.Error(errorData = ResumeError(code = response.code(), message = response.message())))
                    }
                }
            })
        }
}