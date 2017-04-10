package com.marcinmoskala.data

import com.marcinmoskala.data.Learning.Type.Book
import com.marcinmoskala.model.SkillBase

enum class Learning(
        override val visibleName: String,
        val type: Type,
        val comment: String? = null,
        override val description: String? = null,
        override val complition: String? = null
) : SkillBase {
    CleanCode("Clean Code", Book),
    KotlinInAction("Kotlin in Action", Book),
    EffectiveJava("Effective Java", Book, comment = "Not yet finished"),

    ;

    override val linkTo: String? by lazy { "/learning#$id" }

    enum class Type {
        Book, Course
    }

    val id: String
        get() = name

    val connectedSkills: List<Skill> by lazy { Skill.values().filter { this in it.base } }
}