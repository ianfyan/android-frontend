package com.fs.bansosapp.ui.activity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fs.bansosapp.R
import com.fs.bansosapp.databinding.FragmentBansosBinding
import com.fs.bansosapp.ui.adapter.ListBansosAdapter
import com.fs.bansosapp.ui.adapter.ListLocationAdapter
import com.fs.bansosapp.ui.adapter.ListRecipientAdapter
import com.fs.bansosapp.ui.viewmodel.MainViewModel
import com.fs.bansosapp.ui.viewmodel.ViewModelFactory

class BansosFragment : Fragment() {

    private lateinit var binding: FragmentBansosBinding
    private lateinit var mainViewModel: MainViewModel
    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWFsbG93ZWQtcm9sZXMiOlsidXNlciJdLCJ4LWhhc3VyYS1kZWZhdWx0LXJvbGUiOiJ1c2VyIiwieC1oYXN1cmEtdXNlci1pZCI6IjIifX0.9LfRSxwLmytBqlau1nbzCnp999Y-a0UvCDs-7QYSQvI"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBansosBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(activity!!.application)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        setupDropMenu()

        binding.autoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            val value = adapterView.getItemAtPosition(i)
            if (value == "Recipient Data"){
                setupRecipient()
            } else if (value == "Bansos Data"){
                setupBansos()
            }else{
                setupLocation()
            }
        }
    }

    private fun setupDropMenu(){
        val listData = resources.getStringArray(R.array.list_data)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, listData)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    private fun setupRecipient() {
        binding.progressBarBansos.visibility = View.VISIBLE
        mainViewModel.getRecipient(token).observe(this, Observer { recipient ->
            if (recipient != null){
                val adapter = ListRecipientAdapter(recipient)
                binding.rvBansos.layoutManager = LinearLayoutManager(context)
                binding.rvBansos.adapter = adapter
            }
            binding.progressBarBansos.visibility = View.GONE
        })
    }

    private fun setupBansos(){
        binding.progressBarBansos.visibility = View.VISIBLE
        mainViewModel.getBansos(token).observe(this, Observer { bansos ->
            if (bansos != null){
                val adapter = ListBansosAdapter(bansos)
                binding.rvBansos.layoutManager = LinearLayoutManager(context)
                binding.rvBansos.adapter = adapter
            }
            binding.progressBarBansos.visibility = View.GONE
        })
    }

    private fun setupLocation(){
        binding.progressBarBansos.visibility = View.VISIBLE
        mainViewModel.getLocation(token).observe(this, Observer { location ->
            if (location != null){
                val adapter = ListLocationAdapter(location)
                binding.rvBansos.layoutManager = LinearLayoutManager(context)
                binding.rvBansos.adapter = adapter
            }
            binding.progressBarBansos.visibility = View.GONE
        })
    }
}