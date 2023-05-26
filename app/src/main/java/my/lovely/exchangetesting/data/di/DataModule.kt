package my.lovely.exchangetesting.data.di

import my.lovely.exchangetesting.data.api.DataService
import my.lovely.exchangetesting.domain.repository.ExchangeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import my.lovely.exchangetesting.data.repository.ExchangeRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideExchangeRepositoryImpl(dataService: DataService) : ExchangeRepository {
        return ExchangeRepositoryImpl(dataService = dataService)

    }
}