package my.lovely.exchangetesting.presentation.exchange

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import my.lovely.exchangetesting.R
import my.lovely.exchangetesting.databinding.FragmentExchangeBinding
import my.lovely.exchangetesting.presentation.main.CURRENCY_NAME
import my.lovely.exchangetesting.presentation.main.CURRENCY_VALUE


class ExchangeFragment: Fragment(R.layout.fragment_exchange) {

    private lateinit var binding: FragmentExchangeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExchangeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        val currencyValue = arguments?.getString(CURRENCY_VALUE)?.toDouble()
        val currencyName = arguments?.getString(CURRENCY_NAME)

        (activity as AppCompatActivity).supportActionBar?.title = "RUB -------------> $currencyName"



        Log.d("MyLog", currencyValue.toString())
        Log.d("MyLog", currencyName.toString())
    }

}

