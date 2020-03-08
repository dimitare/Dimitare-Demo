package com.dimitare.angdim.model.resume

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResumeData @JvmOverloads constructor(
	val profile : Profile,
	val professionalSummary : ProfessionalSummary? = null,
	val topicsOfKnowledge : TopicsOfKnowledge? = null,
	val workExperience : List<WorkExperience>? = null,
	val education : List<Education>? = null
)