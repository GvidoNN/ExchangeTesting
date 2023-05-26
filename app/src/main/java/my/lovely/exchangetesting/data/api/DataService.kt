package my.lovely.exchangetesting.data.api

import my.lovely.exchangetesting.domain.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface DataService {

    @GET("latest.js")
    suspend fun getMoney(): Response<DataResponse>

}