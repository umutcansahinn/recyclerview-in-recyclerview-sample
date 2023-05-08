package com.umutcansahin.recyclerviewinrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.recyclerviewinrecyclerview.databinding.ChildRecyclerViewItemBinding

class ChildViewHolder(private val binding: ChildRecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(workerName: String) {
        binding.textViewWorkerName.text = workerName
    }
}

class ChildAdapter(private val workerNames: List<String>) :
    RecyclerView.Adapter<ChildViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(
            ChildRecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = workerNames.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(workerNames[position])
    }
}