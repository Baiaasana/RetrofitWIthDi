package com.example.retrofitwithhilt.ui.facts

import android.util.Log.d
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.retrofitwithhilt.databinding.FragmentFactBinding
import com.example.retrofitwithhilt.domain.model.FactModelUi
import com.example.retrofitwithhilt.ui.base.BaseFragment
import com.example.retrofitwithhilt.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FactFragment : BaseFragment<FragmentFactBinding>(FragmentFactBinding::inflate) {

    private val viewModel1: FactViewModel by viewModels()

    override fun listeners() {

        binding.btnGenerate.setOnClickListener {
            viewModel1.getFacts()
            observers()
        }
    }

    override fun init() {
    }

    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel1.factFlow.collect {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            val result = (it.data as FactModelUi)
                            binding.progressBar.isVisible = false
                            binding.tvFact.text = result.fact.toString()
                            d("log","success" )
                        }
                        Resource.Status.ERROR -> {
                            binding.progressBar.isVisible = false
                            d("log","error" )
                        }
                        Resource.Status.LOADING -> {
                            binding.progressBar.isVisible = true
                            d("log","loading" )

                        }
                    }
                }
            }
        }
    }
}