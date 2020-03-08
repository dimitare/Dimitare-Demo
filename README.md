# Dimitare-Demo

This demo is shows a person resume based on a user id. In this case the id is "5e639d5a6a9f800004b61eb4". It is assigned to Dimitare Karagogov

The demo has two flavors: prod, dev. 
dev flavor allows the server responds to be mocked by setting @Named("mockServiceApi")

    @Provides
    fun provideDemoDataSource(@Named("mockServiceApi") demoService: DemoServiceApi): DemoDataSource{
        return DemoRemoteDataSource(demoService)
    }

if the prod server want to be reach please set to @Named("serviceApi"):

    @Provides
    fun provideDemoDataSource(@Named("serviceApi") demoService: DemoServiceApi): DemoDataSource{
        return DemoRemoteDataSource(demoService)
    }


The example demo uses the following technogies:
   - kotlin
   - dagger 2
   - MVVM
   - Navigation 
   - Coroutines
   - databinding
   - LiveData
   
   ![dimitare_demo_resume](https://user-images.githubusercontent.com/2376098/76172466-8e8ce680-6153-11ea-9b03-c5ebfcb2f129.JPEG)
