package com.dimitare.angdim.services.remote

import com.dimitare.angdim.model.ResumeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DemoServiceApi {
    @GET("/api/v1/dimitare/demo/{userId}")
    fun fetchUserProfile(@Path("userId") userId: String): Call<ResumeResponse>
}