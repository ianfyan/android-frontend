package com.fs.bansosapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fs.bansosapp.data.model.LocationsItem
import com.fs.bansosapp.databinding.ItemListDropdownBinding

class ListLocationAdapter(private val location: List<LocationsItem>): RecyclerView.Adapter<ListLocationAdapter.myViewHolder>()  {
    class myViewHolder(private val binding: ItemListDropdownBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(items: LocationsItem){
            with(binding){
                listNama.text = items.nama+", "+items.provinsi
                listNik.text = items.alamat
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = ItemListDropdownBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(location[position])
    }

    override fun getItemCount(): Int = location.size
}