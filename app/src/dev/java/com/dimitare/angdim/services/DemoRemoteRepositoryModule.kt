package com.dimitare.angdim.services

import com.dimitare.angdim.services.remote.DemoRemoteDataSource
import com.dimitare.angdim.services.remote.DemoServiceApi
import com.dimitare.angdim.services.remote.DemoServiceMock
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.mock.BehaviorDelegate
import javax.inject.Named

@Module
class DemoRemoteRepositoryModule {
    @Provides
    fun providesService(demoDataSource: DemoDataSource): DemoService {
        return DemoServiceImpl(demoDataSource)
    }

    @Provides
    fun provideDemoDataSource(@Named("mockServiceApi") demoService: DemoServiceApi): DemoDataSource{
        return DemoRemoteDataSource(demoService)
    }

    @Provides
    @Named("serviceApi")
    fun providesDemoService(retrofit: Retrofit): DemoServiceApi {
        return retrofit.create(DemoServiceApi::class.java)
    }

    @Provides
    @Named("mockServiceApi")
    fun provideMockDemoService(delegate: BehaviorDelegate<DemoServiceApi>): DemoServiceApi{
        return DemoServiceMock(delegate)
    }
}