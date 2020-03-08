package com.dimitare.angdim.services

import com.dimitare.angdim.services.remote.DemoRemoteDataSource
import com.dimitare.angdim.services.remote.DemoServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DemoRemoteRepositoryModule {
    @Provides
    fun providesService(demoDataSource: DemoDataSource): DemoService {
        return DemoServiceImpl(demoDataSource)
    }

    @Provides
    fun provideDemoDataSource(demoService: DemoServiceApi): DemoDataSource{
        return DemoRemoteDataSource(demoService)
    }

    @Provides
    fun providesDemoService(retrofit: Retrofit): DemoServiceApi {
        return retrofit.create(DemoServiceApi::class.java)
    }
}