package com.dimitare.angdim.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimitare.angdim.databinding.SkillCatorogyLayoutItemBinding
import com.dimitare.angdim.model.resume.SkillCategory

class SkillsAdapter: RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>(){
    val mSkills = mutableListOf<SkillCategory>()

    fun setData(items: Collection<SkillCategory>) {
        mSkills.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val binding = SkillCatorogyLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
        return SkillsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mSkills.size
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        holder.binding.skillCategory = mSkills[position]
        holder.binding.executePendingBindings()
    }

    inner class SkillsViewHolder(val binding: SkillCatorogyLayoutItemBinding) : RecyclerView.ViewHolder(binding.root)
}