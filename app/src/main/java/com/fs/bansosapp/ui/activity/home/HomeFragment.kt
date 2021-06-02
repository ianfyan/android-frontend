package com.fs.bansosapp.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fs.bansosapp.data.model.Response.AdminsItem
import com.fs.bansosapp.databinding.FragmentHomeBinding
import com.fs.bansosapp.ui.activity.profil.ProfilActivity
import com.fs.bansosapp.ui.adapter.ListTransactionAdapter
import com.fs.bansosapp.ui.viewmodel.MainViewModel
import com.fs.bansosapp.ui.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var profilData: AdminsItem
    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWFsbG93ZWQtcm9sZXMiOlsidXNlciJdLCJ4LWhhc3VyYS1kZWZhdWx0LXJvbGUiOiJ1c2VyIiwieC1oYXN1cmEtdXNlci1pZCI6IjIifX0.9LfRSxwLmytBqlau1nbzCnp999Y-a0UvCDs-7QYSQvI"
    companion object {
        const val TOKEN_NUMBER ="token"
        fun newInstance(token: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString(TOKEN_NUMBER, token)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //token = this.arguments!!.getString(TOKEN_NUMBER, "Empty")
        //Log.d("Token ", token)

        val factory = ViewModelFactory.getInstance(activity!!.application)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]


        setupListTransaction()
        setupStatistic()
        setupProfil()

        binding.profilImage.setOnClickListener {
            val intent = Intent(context, ProfilActivity::class.java)
            intent.putExtra(ProfilActivity.PROFIL_DATA, profilData)
            startActivity(intent)
        }
    }

    private fun setupListTransaction() {
        binding.homeProgress.visibility = View.VISIBLE
        mainViewModel.getTransaction(token).observe(this, Observer { transaction ->
            if (transaction!=null){
                val adapter: ListTransactionAdapter = ListTransactionAdapter(transaction)
                binding.rvTransaction.layoutManager = LinearLayoutManager(context)
                binding.rvTransaction.adapter = adapter
                binding.homeProgress.visibility = View.GONE
            }
        })
    }

    private fun setupStatistic(){
        mainViewModel.getStatistic(token).observe(this, Observer { statistic ->
            if (statistic != null){
                binding.totalRecip.text = statistic.receipientMapAggregate.aggregate.count.toString()
                binding.totalBansos.text = statistic.bansosAggregate.aggregate.count.toString()
                binding.totalTransaction.text = statistic.transactionsAggregate.aggregate.count.toString()
                binding.totalLocation.text = statistic.transactionsAggregate.aggregate.count.toString()
            }
        })
    }

    private fun setupProfil(){
        mainViewModel.getProfil(token).observe(this, Observer { profil ->
            if (profil != null){
                binding.profilUsername.text = profil.admins[0].nama
                binding.profilEmail.text = profil.admins[0].email
                profilData = profil.admins[0]
            }
        })
    }
}