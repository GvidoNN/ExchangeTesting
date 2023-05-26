package my.lovely.exchangetesting.data.repository

import my.lovely.exchangetesting.domain.repository.ExchangeRepository
import my.lovely.exchangetesting.data.api.DataService
import my.lovely.exchangetesting.domain.model.DataResponse
import retrofit2.Response
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(private val dataService: DataService):
    ExchangeRepository {

    override suspend fun getMoney(): Response<DataResponse>?{
        return try{
            val result = dataService.getNews()
            result
        } catch (e: java.net.UnknownHostException){
            null
        }
    }
}