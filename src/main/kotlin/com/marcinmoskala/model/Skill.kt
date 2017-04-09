package com.marcinmoskala.model

class Skill(
        val name: String,
        val percentage: Int? = null,
        val description: String = "",
        val subskills: List<Skill> = listOf()
)