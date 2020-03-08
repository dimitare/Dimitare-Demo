package com.dimitare.angdim.model.resume

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Positions (
	val jobPosition : String? = null,
	val companyName : String? = null,
	val location : String? = null,
	val duration : String? = null,
	val responsibilities : List<Responsibilities>? = null
)