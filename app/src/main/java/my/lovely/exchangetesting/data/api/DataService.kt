package my.lovely.exchangetesting.data.api

import retrofit2.Response
import retrofit2.http.GET

interface DataService {

    @GET("latest.js")
    suspend fun getNews(): Response<DataResponse>

}