package com.dimitare.angdim.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimitare.angdim.databinding.AchievementsLayoutItemBinding
import com.dimitare.angdim.databinding.ResponsibilitiesLayoutItemBinding
import com.dimitare.angdim.model.resume.Achievements
import com.dimitare.angdim.model.resume.Responsibilities

class AchievementsAdapter: RecyclerView.Adapter<AchievementsAdapter.AchievementsViewHolder>(){
    val mAchievements = mutableListOf<Achievements>()

    fun setData(items: Collection<Achievements>) {
        mAchievements.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementsViewHolder {
        val binding = AchievementsLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
        return AchievementsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mAchievements.size
    }

    override fun onBindViewHolder(holder: AchievementsViewHolder, position: Int) {
        holder.binding.achievementItem = mAchievements[position]
        holder.binding.executePendingBindings()
    }

    inner class AchievementsViewHolder(val binding: AchievementsLayoutItemBinding) : RecyclerView.ViewHolder(binding.root)
}