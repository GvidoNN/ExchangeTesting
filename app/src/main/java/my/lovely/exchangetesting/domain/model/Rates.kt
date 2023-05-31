package my.lovely.exchangetesting.domain.model

data class Rates(
    val AED: Double,
    val AMD: Double,
    val AUD: Double,
    val AZN: Double,
    val BGN: Double,
    val BRL: Double,
    val BYN: Double,
    val CAD: Double,
    val CHF: Double,
    val CNY: Double,
    val CZK: Double,
    val DKK: Double,
    val EGP: Double,
    val EUR: Double,
    val GBP: Double,
    val GEL: Double,
    val HKD: Double,
    val HUF: Double,
    val IDR: Double,
    val INR: Double,
    val JPY: Double,
    val KGS: Double,
    val KRW: Double,
    val KZT: Double,
    val MDL: Double,
    val NOK: Double,
    val NZD: Double,
    val PLN: Double,
    val QAR: Double,
    val RON: Double,
    val RSD: Double,
    val SEK: Double,
    val SGD: Double,
    val THB: Double,
    val TJS: Double,
    val TMT: Double,
    val TRY: Double,
    val UAH: Double,
    val USD: Double,
    val UZS: Double,
    val VND: Double,
    val ZAR: Double
){
    fun getCurrencyNames(): List<String> {
        return listOf(
            "AED", "AMD", "AUD", "AZN", "BGN", "BRL", "BYN", "CAD", "CHF", "CNY", "CZK", "DKK",
            "EGP", "EUR", "GBP", "GEL", "HKD", "HUF", "IDR", "INR", "JPY", "KGS", "KRW", "KZT",
            "MDL", "NOK", "NZD", "PLN", "QAR", "RON", "RSD", "SEK", "SGD", "THB", "TJS", "TMT",
            "TRY", "UAH", "USD", "UZS", "VND", "ZAR"
        )
    }

    fun getCurrencyValue(currencyName: String): Double {
        return when (currencyName) {
            "AED" -> AED
            "AMD" -> AMD
            "AUD" -> AUD
            "AZN" -> AZN
            "BGN" -> BGN
            "BRL" -> BRL
            "BYN" -> BYN
            "CAD" -> CAD
            "CHF" -> CHF
            "CNY" -> CNY
            "CZK" -> CZK
            "DKK" -> DKK
            "EGP" -> EGP
            "EUR" -> EUR
            "GBP" -> GBP
            "GEL" -> GEL
            "HKD" -> HKD
            "HUF" -> HUF
            "IDR" -> IDR
            "INR" -> INR
            "JPY" -> JPY
            "KGS" -> KGS
            "KRW" -> KRW
            "KZT" -> KZT
            "MDL" -> MDL
            "NOK" -> NOK
            "NZD" -> NZD
            "PLN" -> PLN
            "QAR" -> QAR
            "RON" -> RON
            "RSD" -> RSD
            "SEK" -> SEK
            "SGD" -> SGD
            "THB" -> THB
            "TJS" -> TJS
            "TMT" -> TMT
            "TRY" -> TRY
            "UAH" -> UAH
            "USD" -> USD
            "UZS" -> UZS
            "VND" -> VND
            "ZAR" -> ZAR
            else -> 1.0
        }
    }

    fun getRusCurrency(currencyName: String): String {
        return when (currencyName) {
            "AED" -> "Арабаский Дирхам (ОАЭ)"
            "AMD" -> "Армянский драм (Армения)"
            "AUD" -> "Австралийский доллар (Австралия)"
            "AZN" -> "Азербайджанский манат (Азербайджан)"
            "BGN" -> "Болгарский лев (Болгария)"
            "BRL" -> "Бразильский реал (Бразилия)"
            "BYN" -> "Белорусский рубль (Беларусь)"
            "CAD" -> "Канадский доллар (Канада)"
            "CHF" -> "Швейцарский франк (Швейцария)"
            "CNY" -> "Китайский юань (Китай)"
            "CZK" -> "Чешская крона (Чехия)"
            "DKK" -> "Датская крона (Дания)"
            "EGP" -> "Египетский фунт (Египет)"
            "EUR" -> "Евро"
            "GBP" -> "Фунт стерлингов (Великобритания)"
            "GEL" -> "Грузинский лари (Грузия)"
            "HKD" -> "Гонконгский доллар (Конго)"
            "HUF" -> "Венгерский форит (Венгрия)"
            "IDR" -> "Индонезийская рупия (Индонезия)"
            "INR" -> "Индийская рупия (Индия)"
            "JPY" -> "Японская иена (Япония)"
            "KGS" -> "Киргизский сом (Киргизия)"
            "KRW" -> "Южнокорейская вона (Корея)"
            "KZT" -> "Казахский тенге (Казахстан)"
            "MDL" -> "Молдавский лей (Молдавия)"
            "NOK" -> "Норвежская крона (Норвегия)"
            "NZD" -> "Новозеландский доллар (Новая Зеландия)"
            "PLN" -> "Польский злотый (Польша)"
            "QAR" -> "Катарский реал (Катар)"
            "RON" -> "Румынский лей (Румыния)"
            "RSD" -> "Сербский динар (Сербия)"
            "SEK" -> "Шведская крона (Швеция)"
            "SGD" -> "Сингапурский доллар (Сингапур)"
            "THB" -> "Тайский бат (Таиланд)"
            "TJS" -> "Таджикский сомони (Таджикистан)"
            "TMT" -> "Туркменский манат (Туркменистан)"
            "TRY" -> "Турецкая лира (Турция)"
            "UAH" -> "Украинская гривна (Украина)"
            "USD" -> "Доллар (США)"
            "UZS" -> "Узбекский сум (Узбекистан)"
            "VND" -> "Вьетнамский донг (Вьетнам)"
            "ZAR" -> "Южноафрианский рэнд (ЮАР)"
            else -> ""
        }
    }
}