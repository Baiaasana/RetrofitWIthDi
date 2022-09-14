package com.example.retrofitwithhilt.presenter.facts

import android.util.Log.d
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.retrofitwithhilt.data.remote.model.FactModelDTO
import com.example.retrofitwithhilt.databinding.FragmentFactBinding
import com.example.retrofitwithhilt.domain.model.FactModel
import com.example.retrofitwithhilt.presenter.base.BaseFragment
import com.example.retrofitwithhilt.utility.Resource
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

                    binding.apply {
                        progressBar.isVisible = it.isLoading
                        tvFact.text = it.data.fact
                    }
                    if (it.errorMessage != ""){
                        Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}