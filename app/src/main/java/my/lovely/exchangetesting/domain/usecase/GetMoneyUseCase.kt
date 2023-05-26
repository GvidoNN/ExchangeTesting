package my.lovely.exchangetesting.domain.usecase

import my.lovely.exchangetesting.domain.repository.ExchangeRepository
import my.lovely.exchangetesting.domain.model.DataResponse
import retrofit2.Response
import javax.inject.Inject

class GetMoneyUseCase @Inject constructor(private val exchangeRepository: ExchangeRepository) {

    suspend fun getMoney(): Response<DataResponse>? {
        return exchangeRepository.getMoney()
    }


}