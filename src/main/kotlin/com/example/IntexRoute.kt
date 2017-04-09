package com.example

import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.freemarker.FreeMarkerContent
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.indexRoute() {
    get("/") {
        val model = mapOf<Any, Any>(
                "title" to "Marcin Moskala website",
                "sections" to sections
        )
        call.respond(FreeMarkerContent("index.ftl", model, "Index"))
    }
}

class Section(
        val name: String,
        val titleT: String,
        val title: String,
        val tpl: String,
        val css: String
)

val sections = listOf<Any>(
        Section("about-me", "nav.about_me", "About", "about.html", ""),
        Section("career", "nav.career", "Career", "career.html", "timeline"),
        Section("skills", "nav.skills", "Skills", "skills.html", "team"),
        Section("speaking", "nav.speaking", "Speaking", "speaking.html", "timeline"),
        Section("projects", "nav.projects", "Projects", "projects.html", "project"),
        Section("consulting", "nav.consulting", "Contact", "consulting.html", "testimonials navy-section")
)

class Skill(
        val name: String,
        val precentage: Int
)

val skills = listOf(
        Skill("Kotlin", 95),
        Skill("Java", 90),
        Skill("Android", 80),
        Skill("RxJava", 60),
        Skill("Scala", 40),
        Skill("Python", 30)
)

class CareerOrSpeaking(
        val nameT: String,
        val detailT: String,
        val dateT: String,
        val jobT: String,
        val icon: String,
        val link: String? = null
) {
    constructor(nameT: String, icon: String, link: String? = null) : this(nameT, nameT + "_des", nameT + "_date", nameT + "_job", icon, link)
}

val career = listOf(
        CareerOrSpeaking("docplanner", "fa-stethoscope"),
        CareerOrSpeaking("apreel", "fa-car"),
        CareerOrSpeaking("samsung", "fa-mobile"),
        CareerOrSpeaking("college", "fa-book")
)

val speaking = listOf(
        CareerOrSpeaking("mv", "fa-commenting-o", "http://www.warszawskiedniinformatyki.pl"),
        CareerOrSpeaking("reactivex", "fa-newspaper-o", "/static/files/MMReactiveX.pdf"),
        CareerOrSpeaking("kotlinarticle", "fa-newspaper-o", "/static/files/MMKotlin.pdf")
)