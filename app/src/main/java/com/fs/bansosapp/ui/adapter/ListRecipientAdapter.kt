package com.fs.bansosapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fs.bansosapp.data.model.ReceipientsItem
import com.fs.bansosapp.databinding.ItemListDropdownBinding

class ListRecipientAdapter (private val recipient: List<ReceipientsItem>): RecyclerView.Adapter<ListRecipientAdapter.myViewHolder>() {
    class myViewHolder(private val binding: ItemListDropdownBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(items: ReceipientsItem){
            with(binding){
                listNama.text = items.nama+", "+items.nik
                listNik.text = items.alamat
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = ItemListDropdownBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(recipient[position])
    }

    override fun getItemCount(): Int = recipient.size
}