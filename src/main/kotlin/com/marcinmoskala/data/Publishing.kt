package com.marcinmoskala.data

import com.marcinmoskala.data.Publishing.Type.Article
import com.marcinmoskala.data.Publishing.Type.Presentation
import com.marcinmoskala.model.SkillBase
import kotlin.reflect.KProperty

enum class Publishing(
        override val visibleName: String,
        val type: Type,
        val nameT: String,
        val icon: String,
        val link: String? = null,
        val detailT: String = nameT + "_des",
        val dateT: String = nameT + "_date",
        val jobT: String = nameT + "_job",
        val comment: String? = null,
        override val description: String? = null
) : SkillBase {
    MVonWDI("MVC vs MVP vs MVVM pragmatically", Presentation, "mv", "fa-commenting-o", "http://www.warszawskiedniinformatyki.pl"),
    ReactiveX("ReactiveX", Article, "reactivex", "fa-newspaper-o", "/static/files/MMReactiveX.pdf"),
    KotlinArticle("Kotlin - future of Java?", Article, "Kotlin article", "kotlinarticle", "fa-newspaper-o", "/static/files/MMKotlin.pdf")
    ;

    override val linkTo: String? by lazy { "/learning#$id" }

    enum class Type {
        Article, Presentation, Book
    }

    val id: String
        get() = name

    val connectedSkills: List<Skill> by lazy { Skill.values().filter { this in it.base } }

    companion object {
        val all by lazy { values().toList() }
    }
}