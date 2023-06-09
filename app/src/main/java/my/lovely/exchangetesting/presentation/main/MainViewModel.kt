package my.lovely.exchangetesting.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.lovely.exchangetesting.domain.model.DataResponse
import my.lovely.exchangetesting.domain.usecase.GetMoneyUseCase
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class MainViewModel @Inject constructor(private val getMoneyUseCase: GetMoneyUseCase): ViewModel() {

    private val moneyLiveData = MutableLiveData<DataResponse>()
    private var progressBarLiveData = MutableLiveData<Boolean>()
    private val filteredCurrencyNamesLiveData = MutableLiveData<List<String>>()
    private val filteredCurrencyValuesLiveData = MutableLiveData<List<Double>>()

    val filteredCurrencyName: LiveData<List<String>>
        get() = filteredCurrencyNamesLiveData

    val filteredCurrencyValue: LiveData<List<Double>>
        get() = filteredCurrencyValuesLiveData

    val money : LiveData<DataResponse>
        get() = moneyLiveData

    val progressBar: LiveData<Boolean>
        get() = progressBarLiveData

    fun moneyResponse() = viewModelScope.launch(Dispatchers.IO) {
        progressBarLiveData.postValue(true)
        val result = getMoneyUseCase.getMoney()
        moneyLiveData.postValue(result?.body())
        progressBarLiveData.postValue(false)
    }

    fun filterList(query: String?, currencyNames: List<String>, currencyValues: List<Double>, currencyRuNames: List<String>) {
        if (query != null) {
            val filteredNames = ArrayList<String>()
            val filteredValues = ArrayList<Double>()
            val filteredRuNames = ArrayList<String>()
            for (i in currencyNames.indices) {
                if (currencyNames[i].lowercase(Locale.ROOT).contains(query.lowercase())) {
                    filteredNames.add(currencyNames[i])
                    filteredRuNames.add(currencyRuNames[i])
                    filteredValues.add(currencyValues[i])
                }
                if (currencyValues[i].toString().contains(query.toString())){
                    filteredNames.add(currencyNames[i])
                    filteredValues.add(currencyValues[i])
                    filteredRuNames.add(currencyRuNames[i])
                }
                if (currencyRuNames[i].lowercase(Locale.ROOT).contains(query.lowercase())) {
                    filteredRuNames.add(currencyRuNames[i])
                    filteredNames.add(currencyNames[i])
                    filteredValues.add(currencyValues[i])
                }
            }
            if (filteredNames.isEmpty()) {
                //nothing
            } else {
                filteredCurrencyNamesLiveData.value = filteredNames
                filteredCurrencyValuesLiveData.value = filteredValues
            }
        }
    }

}