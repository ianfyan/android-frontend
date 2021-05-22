package com.fs.bansosapp.ui.activity.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fs.bansosapp.data.dummy.BarDummy
import com.fs.bansosapp.databinding.FragmentAnalyzeBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


class AnalyzeFragment : Fragment() {

    private lateinit var binding: FragmentAnalyzeBinding
    private lateinit var data: ArrayList<BarEntry>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalyzeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBarChart()
    }

    private fun setupBarChart(){
        data = BarDummy.getBarData()
        val dataset: BarDataSet = BarDataSet(data, "Recipient")
        //dataset.colors = ColorTemplate.MATERIAL_COLORS
        dataset.setColor(Color.rgb(0, 153, 255))
        dataset.setValueTextColor(Color.BLACK)
        dataset.valueTextSize = 16f

        val barData: BarData = BarData(dataset)

        binding.barChart.setFitBars(true)
        binding.barChart.data = barData
        binding.barChart.description.text = "Bar Chart Example"
        binding.barChart.animateY(2000)
    }

}