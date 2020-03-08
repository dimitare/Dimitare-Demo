package com.dimitare.angdim.utils

import com.dimitare.angdim.Constants
import com.dimitare.angdim.model.ResumeItem
import com.dimitare.angdim.model.resume.*
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class ProfileListDeserializer : JsonDeserializer<MutableList<ResumeItem>>() {
    override fun deserialize(
        jp: JsonParser?,
        ctxt: DeserializationContext?
    ): MutableList<ResumeItem> {
        val values: MutableList<ResumeItem> = mutableListOf()
        val mapper = jacksonObjectMapper()
        val nodes: JsonNode? = jp?.codec?.readTree(jp)
        nodes?.let {
            nodes.map {
                var resumeItem: ResumeItem? = null
                if (it.has(Constants.TYPE_KEY)){
                    when(it.path(Constants.TYPE_KEY).textValue()){
                        Constants.PROFILE_KEY -> resumeItem = mapper.treeToValue(it, Profile::class.java)
                        Constants.PROFESSIONAL_SUMMARY_KEY -> resumeItem = mapper.treeToValue(it, ProfessionalSummary::class.java)
                        Constants.TOPC_OF_KNOWLEDGE_KEY -> resumeItem = mapper.treeToValue(it, TopicsOfKnowledge::class.java)
                        Constants.WORK_EXPERIENCE_KEY -> resumeItem = mapper.treeToValue(it, WorkExperience::class.java)
                        Constants.EDUCATION_KEY -> resumeItem = mapper.treeToValue(it, Education::class.java)
                    }
                    resumeItem?.let { item->
                        values.add(item)
                    }
                }
            }
        }
        return values
    }
}