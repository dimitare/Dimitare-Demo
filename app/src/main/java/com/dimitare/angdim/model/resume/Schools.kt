package com.dimitare.angdim.model.resume

import com.dimitare.angdim.model.resume.Achievements
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Schools  @JvmOverloads constructor(
	val schoolName : String? = null,
	val location : String? = null,
	val duration : String? = null,
	val major : String? = null,
	val achievements : List<Achievements>? = null
)