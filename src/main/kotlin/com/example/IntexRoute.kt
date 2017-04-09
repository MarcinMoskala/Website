package com.example

import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.freemarker.FreeMarkerContent
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.indexRoute() {
    get("/") {
        val model = mapOf<Any, Any>(
                "title" to "Marcin Moskala website",
                "languages" to languages,
                "sections" to sections,
                "careers" to career,
                "projects" to projets
        )
        call.respond(FreeMarkerContent("index.ftl", model, "Index"))
    }
}

class Language(val locale: String, val flag: String)

val languages = listOf(
        Language("en", "static/img/flags/United-States.png"),
        Language("pl", "static/img/flags/Poland.png")
)

class Section(
        val name: String,
        val titleT: String,
        val title: String,
        val tpl: String,
        val css: String
)

val sections = listOf<Any>(
        Section("about-me", "nav.about_me", "About", "about.ftl", ""),
        Section("career", "nav.career", "Career", "career.ftl", "timeline"),
        Section("skills", "nav.skills", "Skills", "skills.ftl", "team"),
        Section("speaking", "nav.speaking", "Speaking", "speaking.ftl", "timeline"),
        Section("projects", "nav.projects", "Projects", "projects.ftl", "project"),
        Section("consulting", "nav.consulting", "Contact", "consulting.ftl", "testimonials navy-section")
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

class Project(
        val name: String,
        val descT: String,
        val url: String,
        val img: String
)

val projets = listOf(
        Project("Docplanner Doctor App", "DocplannerDoctor", "//play.google.com/store/apps/details?id=pl.znanylekarz.lekarz", "static/img/landing/ic_launcher.png"),
        Project("Warta Mobile", "WartaMobile", "//play.google.com/store/apps/details?id=pl.warta.mobile", "static/img/landing/warta.png"),
        Project("Activity Starter", "ActivityStarter", "https://github.com/MarcinMoskala/ActivityStarter", "static/img/landing/github.png"),
        Project("Kotlin Wonders", "KotlinWonders", "//github.com/MarcinMoskala/kotlinWonders", "static/img/landing/github.png"),
        Project("KotlinPreferences", "KotlinPreferences", "https://github.com/MarcinMoskala/KotlinPreferences", "static/img/landing/github.png"),
        Project("PreferenceHolder", "PreferenceHolder", "https://github.com/MarcinMoskala/PreferenceHolder", "static/img/landing/github.png"),
        Project("Nootro", "Nootro", "http://nootro.pl/", "static/img/landing/nootro.png"),
        Project("Stack Tester", "StackTester", "https://github.com/MarcinMoskala/StackTester", "static/img/landing/st.png")
)