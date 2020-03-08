package com.dimitare.angdim.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimitare.angdim.databinding.ResponsibilitiesLayoutItemBinding
import com.dimitare.angdim.model.resume.Responsibilities

class ResponsibilitiesAdapter: RecyclerView.Adapter<ResponsibilitiesAdapter.ResponsibilitiesViewHolder>(){
    val mResponsibilities = mutableListOf<Responsibilities>()

    fun setData(items: Collection<Responsibilities>) {
        mResponsibilities.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponsibilitiesViewHolder {
        val binding = ResponsibilitiesLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
        return ResponsibilitiesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mResponsibilities.size
    }

    override fun onBindViewHolder(holder: ResponsibilitiesViewHolder, position: Int) {
        holder.binding.responsibilitiesItem = mResponsibilities[position]
        holder.binding.executePendingBindings()
    }

    inner class ResponsibilitiesViewHolder(val binding: ResponsibilitiesLayoutItemBinding) : RecyclerView.ViewHolder(binding.root)
}