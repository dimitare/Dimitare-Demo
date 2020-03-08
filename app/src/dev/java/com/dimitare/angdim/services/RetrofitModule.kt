package com.dimitare.angdim.services

import com.dimitare.angdim.BuildConfig
import com.dimitare.angdim.services.remote.DemoServiceApi
import com.dimitare.angdim.services.remote.DemoServiceMock
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
        .baseUrl(BuildConfig.PROFILE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesBehaviorDelegate(): BehaviorDelegate<DemoServiceApi> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mock-service-api")
            .build()
        val mockRetrofit = MockRetrofit.Builder(retrofit)
            .networkBehavior(NetworkBehavior.create())
            .build()

        return mockRetrofit.create(DemoServiceApi::class.java)
    }

    @Provides
    fun providesOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}