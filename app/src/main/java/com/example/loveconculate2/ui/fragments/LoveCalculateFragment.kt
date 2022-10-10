package com.example.loveconculate2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.loveconculate2.App
import com.example.loveconculate2.R
import com.example.loveconculate2.databinding.FragmentLoveCalculateBinding
import com.example.loveconculate2.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoveCalculateFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalculateBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoveCalculateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).observe(requireActivity(), Observer {
                    App.appDataBase.loveDao().insert(it)
                    val bundle = Bundle()
                    bundle.putSerializable("model", it)
                    findNavController().navigate(R.id.loveResultFragment, bundle)
                })
            }
        }
    }
}