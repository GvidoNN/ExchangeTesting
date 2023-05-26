package my.lovely.exchangetesting.domain.model

data class DataResponse(
    val base: String,
    val date: String,
    val disclaimer: String,
    val rates: Rates,
    val timestamp: Int
)