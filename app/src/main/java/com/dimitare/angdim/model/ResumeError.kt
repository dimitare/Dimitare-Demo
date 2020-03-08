package com.dimitare.angdim.model

data class ResumeError(
    val status : String = "Error",
    val code : Int = -1,
    val message : String? = null
)