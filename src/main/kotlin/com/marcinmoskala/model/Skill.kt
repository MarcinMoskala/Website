package com.marcinmoskala.model

class Skill(
        val name: String,
        val percentage: Int? = null,
        val description: String = "",
        val visibleOnMain: Boolean = false,
        val subskills: List<Skill> = listOf(),
        val base: List<Skill.Base> = listOf(),
        val url: String? = null,
        val id: String = name.replace("[^\\w]*".toRegex(), "")
) {
    class Base(
            val name: String,
            val url: String,
            val description: String
    )
}