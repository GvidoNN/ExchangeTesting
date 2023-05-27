package my.lovely.exchangetesting.presentation.exchange

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import my.lovely.exchangetesting.R
import my.lovely.exchangetesting.presentation.main.CURRENCY_NAME
import my.lovely.exchangetesting.presentation.main.CURRENCY_VALUE


class ExchangeFragment: Fragment(R.layout.fragment_exchange) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currencyValue = arguments?.getString(CURRENCY_VALUE)?.toDouble()
        val currencyName = arguments?.getString(CURRENCY_NAME)


        Log.d("MyLog", currencyValue.toString())
        Log.d("MyLog", currencyName.toString())
    }

}

