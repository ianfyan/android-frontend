package com.fs.bansosapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fs.bansosapp.data.model.BansosItem
import com.fs.bansosapp.databinding.ItemListDropdownBinding

class ListBansosAdapter(private val bansos: List<BansosItem>): RecyclerView.Adapter<ListBansosAdapter.myViewHolder>()  {
    class myViewHolder(private val binding: ItemListDropdownBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(items: BansosItem){
            with(binding){
                if (items.isActive){
                    listNama.text = items.location.nama+", Aktif"
                }else{
                    listNama.text = items.location.nama+", Non Aktif"
                }
                listNik.text = "Tersedia : "+items.stock
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = ItemListDropdownBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(bansos[position])
    }

    override fun getItemCount(): Int = bansos.size
}