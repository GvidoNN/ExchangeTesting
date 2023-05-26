package my.lovely.exchangetesting.presentation.main

import android.util.Log
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
    private val filteredCurrencyLiveData = MutableLiveData<List<String>>()


    val filteredMoney: LiveData<List<String>>
        get() = filteredCurrencyLiveData

    val money : LiveData<DataResponse>
        get() = moneyLiveData

    val progressBar: LiveData<Boolean>
        get() = progressBarLiveData

    fun moneyResponse() = viewModelScope.launch(Dispatchers.IO) {
        progressBarLiveData.postValue(true)
        var result = getMoneyUseCase.getMoney()
        moneyLiveData.postValue(result?.body() ?: null)
        progressBarLiveData.postValue(false)
    }

    fun filterList(query: String?, currencyNames: List<String>) {
        if (query != null) {
            val filteredList = ArrayList<String>()
            for (i in currencyNames) {
                if (i.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Log.d("MyLog","No data")
            } else {
                filteredCurrencyLiveData.value = filteredList
            }
        }
    }

}