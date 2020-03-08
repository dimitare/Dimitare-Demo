package com.dimitare.angdim.model.resume

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Responsibilities  @JvmOverloads constructor(
	val bulletPoint : String? = null
)