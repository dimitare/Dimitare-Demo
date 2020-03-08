package com.dimitare.angdim.model.resume

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SkillCategory @JvmOverloads constructor(
	val title : String? = null,
	val content : String? = null
)