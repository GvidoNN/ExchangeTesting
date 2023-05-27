package my.lovely.exchangetesting.data.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import my.lovely.exchangetesting.data.api.DataService
import my.lovely.exchangetesting.domain.model.DataResponse
import my.lovely.exchangetesting.domain.model.Rates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response
import retrofit2.Retrofit

class ExchangeRepositoryImplTest {

    private val dataService = mock<DataService>()
    private val retrofit = mock<Retrofit>()

    private val exchangeRepository = ExchangeRepositoryImpl(dataService)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getMoney returns DataResponse from repository`() = runTest {

        val testDataResponse = DataResponse(base = "test", date = "test", disclaimer = "test", rates = Rates(
            1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0), timestamp = 1)

        whenever(retrofit.create(DataService::class.java)).thenReturn(dataService)
        whenever(dataService.getMoney()).thenReturn(Response.success(testDataResponse))

        assertEquals(
            testDataResponse,
            exchangeRepository.getMoney()?.body()
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getSearchInside from repository returns Error because of Internet`() = runTest {

        val testDataResponse = null

        whenever(retrofit.create(DataService::class.java)).thenReturn(dataService)
        whenever(dataService.getMoney()).thenReturn(Response.success(testDataResponse))

        assertEquals(
            testDataResponse,
            exchangeRepository.getMoney()?.body()
        )
    }



}