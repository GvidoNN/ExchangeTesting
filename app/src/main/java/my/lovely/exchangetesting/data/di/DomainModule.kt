package my.lovely.exchangetesting.data.di

import my.lovely.exchangetesting.domain.repository.ExchangeRepository
import my.lovely.exchangetesting.domain.usecase.GetMoneyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetMoneyUseCase(exchangeRepository: ExchangeRepository): GetMoneyUseCase {
        return GetMoneyUseCase(exchangeRepository = exchangeRepository)
    }

}