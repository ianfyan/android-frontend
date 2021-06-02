package com.fs.bansosapp.ui.activity.slider

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.fs.bansosapp.R
import com.fs.bansosapp.data.model.SliderModel
import com.fs.bansosapp.databinding.ActivitySliderBinding
import com.fs.bansosapp.ui.activity.auth.LoginActivity
import com.fs.bansosapp.ui.adapter.SliderAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SliderActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySliderBinding
    private lateinit var listSlider: ArrayList<SliderModel>
    private lateinit var sliderPager: ViewPager2
    private lateinit var indicator: TabLayout
    private val slideHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sliderPager = binding.pageSlider
        indicator = binding.sliderIndicator

        setupDataSlider()
        setupSlider()

        binding.sliderButton.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setupDataSlider(){
        listSlider = ArrayList()
        listSlider.add(SliderModel(R.drawable.slider_1, getString(R.string.slider_1)))
        listSlider.add(SliderModel(R.drawable.slider_2, getString(R.string.slider_2)))
        listSlider.add(SliderModel(R.drawable.slider_3, getString(R.string.slider_3)))
    }

    private fun setupSlider(){
        sliderPager.adapter = SliderAdapter(listSlider)
        TabLayoutMediator(indicator, sliderPager){ tab, position ->
        }.attach()

        sliderPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                slideHandler.removeCallbacks(sliderRunnable)
                slideHandler.postDelayed(sliderRunnable, 5000)
            }
        })
    }

    private val sliderRunnable = Runnable {
        if (sliderPager.currentItem <  2){
            sliderPager.setCurrentItem(sliderPager.currentItem+1)
        }else{
            sliderPager.setCurrentItem(0)
        }
    }
}