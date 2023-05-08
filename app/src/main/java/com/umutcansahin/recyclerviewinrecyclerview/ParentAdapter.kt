package com.umutcansahin.recyclerviewinrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.recyclerviewinrecyclerview.databinding.ParentRecyclerViewItemBinding

class ParentViewHolder(private val binding: ParentRecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(company: Company) {
        binding.textViewCompanyName.text = company.name
        binding.textViewWorkerCount.text = company.worker.toString()
        val childAdapter = ChildAdapter(company.workerName)
        binding.childRecyclerView.adapter = childAdapter
    }
}

class ParentAdapter(private val list: List<Company>) : RecyclerView.Adapter<ParentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            ParentRecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
       holder.bind(list[position])
    }
}