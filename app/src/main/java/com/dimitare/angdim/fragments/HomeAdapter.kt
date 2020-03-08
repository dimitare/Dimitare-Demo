package com.dimitare.angdim.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dimitare.angdim.R
import com.dimitare.angdim.databinding.*
import com.dimitare.angdim.model.ResumeItem
import com.dimitare.angdim.model.resume.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    var mResumeItems: MutableList<ResumeItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        when (viewType) {
            PROFILE_TYPE -> {
                val binding = ProfileLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
                return ProfileHolder(binding)
            }
            PROFESSIONAL_SUMMARY_TYPE -> {
                val binding = ProfessionalSummaryLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
                return ProfessionalSummaryHolder(binding)
            }
            TOPIC_OF_KNOWLEDGE_TYPE -> {
                val binding = TopicsOfKnowledgeLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
                return TopicOfKnowledgeHolder(binding)
            }
            WORK_EXPERIENCE_TYPE -> {
                val binding = WorkExperienceLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
                return WorkExperienceHolder(binding)
            }
            EDUCATION_TYPE -> {
                val binding = EducationLayoutItemBinding.inflate(LayoutInflater.from(parent.context))
                return EducationHolder(binding)
            }
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_layout_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mResumeItems.size
    }

    override fun getItemViewType(position: Int): Int {
        when (mResumeItems[position]) {
            is Profile -> return PROFILE_TYPE
            is ProfessionalSummary -> return PROFESSIONAL_SUMMARY_TYPE
            is TopicsOfKnowledge -> return TOPIC_OF_KNOWLEDGE_TYPE
            is WorkExperience -> return WORK_EXPERIENCE_TYPE
            is Education -> return EDUCATION_TYPE
        }
        return DEFAULT_TYPE
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        when(holder){
            is ProfileHolder -> {
                val profile = mResumeItems[position] as? Profile
                profile?.let { p ->
                    holder.binding.profile = p
                    holder.binding.executePendingBindings()
                }
            }
            is ProfessionalSummaryHolder -> {
                val professionalSummary = mResumeItems[position] as? ProfessionalSummary
                professionalSummary?.let { p ->
                    holder.binding.professionalSummary = p
                    holder.binding.executePendingBindings()
                }
            }
            is TopicOfKnowledgeHolder -> {
                val topicsOfKnowledge = mResumeItems[position] as? TopicsOfKnowledge
                topicsOfKnowledge?.let { t ->
                    holder.binding.topicsOfKnowledge = t
                    val skills = t.categories
                    skills?.let {
                        holder.binding.skills.apply {
                            adapter = SkillsAdapter()
                        }
                    }
                }
                holder.binding.executePendingBindings()
            }
            is WorkExperienceHolder -> {
                val workExperience = mResumeItems[position] as? WorkExperience
                workExperience?.let { w ->
                    holder.binding.workExperience = w
                    val positions = w.positions
                    positions?.let {
                        holder.binding.positions.apply {
                            adapter = PositionsAdapter()
                        }
                    }
                }
            }
            is EducationHolder -> {
                val education = mResumeItems[position] as? Education
                education?.let { e ->
                    holder.binding.education = e
                    val schools = e.schools
                    schools?.let {
                        holder.binding.schools.apply {
                            adapter = SchoolsAdapter()
                        }
                    }
                }
            }
        }
    }

    fun setData(items: Collection<ResumeItem>) {
        mResumeItems.addAll(items)
    }

    open inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    private inner class ProfileHolder(val binding: ProfileLayoutItemBinding) : HomeViewHolder(binding.root) {}

    private inner class ProfessionalSummaryHolder(val binding: ProfessionalSummaryLayoutItemBinding): HomeViewHolder(binding.root)

    private inner class TopicOfKnowledgeHolder(val binding: TopicsOfKnowledgeLayoutItemBinding): HomeViewHolder(binding.root)

    private inner class WorkExperienceHolder(val binding: WorkExperienceLayoutItemBinding): HomeViewHolder(binding.root)

    private inner class EducationHolder(val binding: EducationLayoutItemBinding): HomeViewHolder(binding.root)

    companion object {
        private const val DEFAULT_TYPE = 0
        private const val PROFILE_TYPE = 1
        private const val PROFESSIONAL_SUMMARY_TYPE = 2
        private const val TOPIC_OF_KNOWLEDGE_TYPE = 3
        private const val WORK_EXPERIENCE_TYPE = 4
        private const val EDUCATION_TYPE = 5
    }
}