package com.fs.bansosapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fs.bansosapp.data.SliderModel
import com.fs.bansosapp.databinding.ItemSliderBinding

class SliderAdapter(private val sliderList: ArrayList<SliderModel>): RecyclerView.Adapter<SliderAdapter.myViewHolder>() {

    class myViewHolder(private val binding: ItemSliderBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(items: SliderModel){
            with(binding){
                Glide.with(itemView.context)
                    .load(items.image)
                    .apply(RequestOptions().override(800, 800))
                    .into(sliderImage)
                sliderText.text = items.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding =ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(sliderList[position])
    }

    override fun getItemCount(): Int = sliderList.size
}