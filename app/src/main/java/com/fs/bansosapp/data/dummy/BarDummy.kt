package com.fs.bansosapp.data.dummy

import com.github.mikephil.charting.data.BarEntry

object BarDummy {
    fun getBarData(): ArrayList<BarEntry> {
        val listBar = ArrayList<BarEntry>()
        listBar.add(BarEntry(2014f, 321f))
        listBar.add(BarEntry(2015f, 472f))
        listBar.add(BarEntry(2016f, 459f))
        listBar.add(BarEntry(2017f, 422f))
        listBar.add(BarEntry(2018f, 398f))
        listBar.add(BarEntry(2019f, 380f))
        listBar.add(BarEntry(2020f, 401f))
        listBar.add(BarEntry(2021f, 416f))
        return listBar
    }
}