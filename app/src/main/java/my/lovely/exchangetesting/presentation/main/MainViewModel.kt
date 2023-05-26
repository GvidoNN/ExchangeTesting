package my.lovely.exchangetesting.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.lovely.exchangetesting.R
import my.lovely.exchangetesting.domain.model.DataResponse
import my.lovely.exchangetesting.domain.usecase.GetMoneyUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getMoneyUseCase: GetMoneyUseCase): ViewModel() {

    private val moneyLiveData = MutableLiveData<DataResponse>()
    private var progressBarLiveData = MutableLiveData<Boolean>()

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

}