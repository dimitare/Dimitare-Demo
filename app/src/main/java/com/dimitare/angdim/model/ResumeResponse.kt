package com.dimitare.angdim.model

import com.dimitare.angdim.utils.ProfileListDeserializer
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResumeResponse @JsonCreator constructor(
	@JsonProperty("code") val code : Int,
	@JsonDeserialize(using = ProfileListDeserializer::class)
	@JsonProperty("resumeData") val resumeData : List<ResumeItem>?,
	@JsonProperty("httpStatusCode") val httpStatusCode : Int
)