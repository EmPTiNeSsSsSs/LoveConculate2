package com.example.loveconculate2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.loveconculate2.App
import com.example.loveconculate2.R
import com.example.loveconculate2.data.models.LoveModel
import com.example.loveconculate2.databinding.FragmentHistoryBinding
import com.example.loveconculate2.ui.adapters.HistoryAdapter

class HistoryFragment : Fragment() {

    private lateinit var binding : FragmentHistoryBinding
    private var adapter = HistoryAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appDataBase.loveDao().getAll().observe( requireActivity(), Observer {
            adapter = HistoryAdapter(it as ArrayList<LoveModel>)
            binding.recyclerViewHistory.adapter = adapter
        })
    }
}