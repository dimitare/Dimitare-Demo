package com.dimitare.angdim.model.resume

import com.dimitare.angdim.model.ResumeItem
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Education @JvmOverloads constructor(
	val categoryName : String? = null,
	val schools : List<Schools>? = null
): ResumeItem