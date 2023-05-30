package my.lovely.exchangetesting.presentation.exchange

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import my.lovely.exchangetesting.R
import my.lovely.exchangetesting.databinding.FragmentExchangeBinding
import my.lovely.exchangetesting.presentation.main.CURRENCY_NAME
import my.lovely.exchangetesting.presentation.main.CURRENCY_VALUE


class ExchangeFragment : Fragment(R.layout.fragment_exchange) {

    private lateinit var binding: FragmentExchangeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        binding.edCurrencyValue.setText("1")
        val costOfOne = 1 / currencyValue!!
        binding.edRublesValue.setText(costOfOne.toString())
        binding.tvCurrencyName1.text = currencyName

        (activity as AppCompatActivity).supportActionBar?.title = "RUB -------------> $currencyName"

        var isUpdatingRubles = false
        var isUpdatingCurrency = false

        binding.edRublesValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isUpdatingRubles) {
                    if (s.toString() != "" && s.toString() != "." && s.toString() != ",") {
                        val value = s.toString().toDouble() * currencyValue.toDouble()
                        isUpdatingCurrency = true
                        binding.edCurrencyValue.setText(value.toString())
                        isUpdatingCurrency = false
                    } else {
                        isUpdatingCurrency = true
                        binding.edCurrencyValue.setText("")
                        isUpdatingCurrency = false
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.edCurrencyValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isUpdatingCurrency) {
                    if (s.toString() != "" && s.toString() != "." && s.toString() != ",") {
                        val value = s.toString().toDouble() / currencyValue.toDouble()
                        isUpdatingRubles = true
                        binding.edRublesValue.setText(value.toString())
                        isUpdatingRubles = false
                    } else {
                        isUpdatingRubles = true
                        binding.edRublesValue.setText("")
                        isUpdatingRubles = false
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }
}

