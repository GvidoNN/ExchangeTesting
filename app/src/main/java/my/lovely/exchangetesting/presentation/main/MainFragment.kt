package my.lovely.exchangetesting.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import my.lovely.exchangetesting.R
import my.lovely.exchangetesting.databinding.FragmentMainBinding


@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private lateinit var errorContainer: LinearLayout
    private lateinit var btErrorTryAgain: Button
    private lateinit var adapter: CurrencyAdapter
    private lateinit var currencyNames: List<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        errorContainer = requireView().findViewById(R.id.errorContainer)
        btErrorTryAgain = requireView().findViewById(R.id.btErrorTryAgain)

        mainViewModel.moneyResponse()

        mainViewModel.money.observe(viewLifecycleOwner) { result ->
            if (result != null) {
                currencyNames = result.rates.getCurrencyNames()
                val currencyValues = currencyNames.map { result.rates.getCurrencyValue(it) }
                adapter = CurrencyAdapter(currencyNames, currencyValues)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                errorContainer.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE

            } else {
                Log.d("MyLog","Error")
                errorContainer.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
                binding.searchView.isVisible = false
            }
        }

        mainViewModel.progressBar.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it == true
        }

        btErrorTryAgain.setOnClickListener {
            mainViewModel.moneyResponse()
        }

        mainViewModel.filteredMoney.observe(viewLifecycleOwner) {
            adapter.setFilteredList(it)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mainViewModel.filterList(newText, currencyNames)
                return true
            }

        })
    }

}