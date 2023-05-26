package my.lovely.exchangetesting.presentation.main

import android.os.Bundle
import android.speech.SpeechRecognizer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import my.lovely.exchangetesting.R
import my.lovely.exchangetesting.databinding.FragmentMainBinding


@AndroidEntryPoint
class MainFragment: Fragment(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private lateinit var speechRecognizer: SpeechRecognizer

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

        mainViewModel.moneyResponse()

        mainViewModel.money.observe(viewLifecycleOwner) { result ->
            Log.d("MyLog",result.toString())
        }

    }
}