package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.viewBinding

class MainFragment : Fragment(R.layout.main_fragment) {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val binding: MainFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setObservers()

        viewModel.loadTextContent()
    }

    private fun setObservers() {
        observe(viewModel.text) {
            binding.message.text = it
        }
    }
}

inline fun <reified T : Any?> LifecycleOwner.observe(
    liveData: LiveData<T>,
    crossinline action: (T) -> Unit
) {
    liveData.observe(this, Observer { value -> value?.apply(action) })
}