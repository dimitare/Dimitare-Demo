package com.dimitare.angdim.model

import com.dimitare.angdim.services.remote.RemoteResource

class ResumeResult(val mUserResume: List<ResumeItem>? = null, val status: RemoteResource<ResumeResponse, ResumeError>)