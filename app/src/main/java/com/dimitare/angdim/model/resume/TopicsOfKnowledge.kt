package com.dimitare.angdim.model.resume

import com.dimitare.angdim.model.ResumeItem
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class TopicsOfKnowledge @JvmOverloads constructor(
	val categoryName : String? = null,
	val categories : List<SkillCategory>? = null
): ResumeItem