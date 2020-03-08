package com.dimitare.angdim.model.resume

import com.dimitare.angdim.model.ResumeItem
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Profile @JvmOverloads constructor(
	val name : String,
	val avatar: String? = null,
	val address : String? = null,
	val phone : String? = null,
	val linkedIn : String? = null
): ResumeItem