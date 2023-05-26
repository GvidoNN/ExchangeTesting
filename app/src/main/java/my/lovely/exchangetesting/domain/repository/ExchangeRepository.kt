package my.lovely.exchangetesting.domain.repository

import my.lovely.exchangetesting.domain.model.DataResponse
import retrofit2.Response

interface ExchangeRepository {

    suspend fun getMoney(): Response<DataResponse>?

}