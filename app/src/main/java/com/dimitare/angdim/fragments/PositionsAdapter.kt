package com.dimitare.angdim.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimitare.angdim.databinding.PositionsLayoutItemBinding
import com.dimitare.angdim.model.resume.Positions

class PositionsAdapter : RecyclerView.Adapter<PositionsAdapter.PositionViewHolder>() {
    val mPositions = mutableListOf<Positions>()

    fun setData(items: Collection<Positions>) {
        mPositions.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        val binding = PositionsLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
        return PositionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mPositions.size
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        val positions = mPositions[position]
        holder.binding.positionItem = positions
        val responsibilities = positions.responsibilities
        responsibilities?.let { r ->
            holder.binding.responsibilities.apply {
                adapter = ResponsibilitiesAdapter()
            }
        }
        holder.binding.executePendingBindings()
    }

    inner class PositionViewHolder(val binding: PositionsLayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}