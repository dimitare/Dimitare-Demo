package com.dimitare.angdim.fragments.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.dimitare.angdim.BuildConfig
import com.dimitare.angdim.dagger.qualifier.FragmentScope
import com.dimitare.angdim.fragments.ResumeProfileData
import com.dimitare.angdim.model.ResumeItem
import com.dimitare.angdim.model.ResumeError
import com.dimitare.angdim.model.ResumeResponse
import com.dimitare.angdim.model.ResumeResult
import com.dimitare.angdim.services.DemoService
import com.dimitare.angdim.services.remote.RemoteResource
import kotlinx.coroutines.launch
import javax.inject.Inject

@FragmentScope
class HomeFragmentViewModel @Inject constructor(val mDemoService: DemoService) :
    BaseViewFragmentViewModel() {
    val startUpdate: MediatorLiveData<Boolean> = MediatorLiveData()
    var mUserId: String? = BuildConfig.USER_ID

    val mUserResumeStatus: MutableLiveData<ResumeResult> = MutableLiveData()
    val mUserResume: LiveData<List<ResumeItem>?> = mUserResumeStatus.switchMap {
        Log.w("Dimitare", "mUserResumeStatus: $mUserResumeStatus")
        var userResume: List<ResumeItem>? = null
        when(it.status){
            is RemoteResource.Success -> {
                userResume = it.mUserResume
            }
            else -> {
            }
        }
        MutableLiveData(userResume)
    }

    init {
        startUpdate.value = false
    }

    override fun startViewModel() {
        super.startViewModel()
        if (mUserResume.value == null) {
            fetchUserResumeResults()
        }
    }

    override fun stopViewModel() {
        super.stopViewModel()
    }

    private fun fetchUserResumeResults() {
        mUserId?.let {
            mUserResumeStatus.postValue(ResumeResult(status = RemoteResource.Loading()))
            viewModelScope.launch {
                mDemoService.fetchResumeById(it)
            }
        }
    }

    override fun unsubscribe() {
        startUpdate.removeSource(mDemoService.observeResume().distinctUntilChanged())
    }

    override fun subscribe() {
        startUpdate.addSource(mDemoService.observeResume().distinctUntilChanged()) {
            when (it) {
                is RemoteResource.Success<ResumeResponse, ResumeError> -> {
                    it.data?.resumeData?.let { resumeData ->
                        mUserResumeStatus.postValue(ResumeResult(resumeData, it))
                    } ?: mUserResumeStatus.postValue(
                        ResumeResult(
                            status = RemoteResource.Error(
                                errorData = ResumeError(message = "Some internal error occurred"),
                                errorMessage = "Some internal error occurred"
                            )
                        )
                    )
                }
                is RemoteResource.Error<ResumeResponse, ResumeError> -> {
                    mUserResumeStatus.postValue(
                        ResumeResult(
                            status = it
                        )
                    )
                }
            }
        }
    }
}