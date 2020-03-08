package com.dimitare.angdim.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimitare.angdim.databinding.SchoolLayoutItemBinding
import com.dimitare.angdim.model.resume.Schools

class SchoolsAdapter: RecyclerView.Adapter<SchoolsAdapter.SchoolsViewHolder>(){
    val mSchools = mutableListOf<Schools>()

    fun setData(items: Collection<Schools>) {
        mSchools.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolsViewHolder {
        val binding = SchoolLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
        return SchoolsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mSchools.size
    }

    override fun onBindViewHolder(holder: SchoolsViewHolder, position: Int) {
        val school = mSchools[position]
        holder.binding.school = school
        val achievements = school.achievements
        achievements?.let {a ->
            holder.binding.achievements.apply {
                adapter = AchievementsAdapter()
            }
        }
        holder.binding.executePendingBindings()
    }

    inner class SchoolsViewHolder(val binding: SchoolLayoutItemBinding) : RecyclerView.ViewHolder(binding.root)
}