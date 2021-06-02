package com.fs.bansosapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fs.bansosapp.data.model.TransactionsItem
import com.fs.bansosapp.databinding.ItemHomeBinding

class ListTransactionAdapter (private val transaction: List<TransactionsItem>): RecyclerView.Adapter<ListTransactionAdapter.myViewHolder>()  {
    class myViewHolder(private val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root)  {
        fun bind(items: TransactionsItem){
            with(binding){
                val delim = "T"
                val poin = "."
                val date = items.createdAt.split(delim)
                val time = date[1].split(poin)

                transName.text = items.receipient.nama+", "+items.bansos.location.nama
                transNik.text = items.receipient.nik
                transDate.text = date[0]
                transTime.text = time[0]
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(transaction[position])
    }

    override fun getItemCount(): Int = transaction.size
}