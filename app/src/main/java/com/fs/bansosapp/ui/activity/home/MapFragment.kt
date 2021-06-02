package com.fs.bansosapp.ui.activity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fs.bansosapp.R
import com.fs.bansosapp.data.model.BansosItem
import com.fs.bansosapp.databinding.FragmentMapBinding
import com.fs.bansosapp.ui.viewmodel.MainViewModel
import com.fs.bansosapp.ui.viewmodel.ViewModelFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private lateinit var googleMap: GoogleMap
    private lateinit var mainViewModel: MainViewModel
    private lateinit var dataBansos: List<BansosItem>
    val token: String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWFsbG93ZWQtcm9sZXMiOlsidXNlciJdLCJ4LWhhc3VyYS1kZWZhdWx0LXJvbGUiOiJ1c2VyIiwieC1oYXN1cmEtdXNlci1pZCI6IjIifX0.9LfRSxwLmytBqlau1nbzCnp999Y-a0UvCDs-7QYSQvI"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(activity!!.application)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0

        for (i in getMap()){
            googleMap.addMarker(MarkerOptions().position(i).title("Position Marker"))
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(30.0f))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(i))
        }
    }

    fun getMap(): ArrayList<LatLng> {
        val listMarker: ArrayList<LatLng> = ArrayList()
        mainViewModel.getBansos(token).observe(this, Observer { item ->
            if (item != null){
                dataBansos = item
            }
            for (i in dataBansos){
                listMarker.add(LatLng(i.latitude.toDouble(), i.longitude.toDouble()))
            }
        })
        return listMarker
    }

}