package com.marcinmoskala.presentation

import com.marcinmoskala.data.languages
import com.marcinmoskala.data.projetsOnMain
import com.marcinmoskala.data.skillsVisible
import com.marcinmoskala.model.Achievement
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.freemarker.FreeMarkerContent
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.indexRoute() {
    get("/") {
        val career = listOf(
                Achievement("docplanner", "fa-stethoscope"),
                Achievement("apreel", "fa-car"),
                Achievement("samsung", "fa-mobile"),
                Achievement("college", "fa-book")
        )

        val speaking = listOf(
                Achievement("mv", "fa-commenting-o", "http://www.warszawskiedniinformatyki.pl"),
                Achievement("reactivex", "fa-newspaper-o", "/static/files/MMReactiveX.pdf"),
                Achievement("kotlinarticle", "fa-newspaper-o", "/static/files/MMKotlin.pdf")
        )
        val sections = listOf(
                Section("about-me", "nav.about_me", "About", "about.ftl", ""),
                Section("career", "nav.career", "Career", "career.ftl", "timeline"),
                Section("skills", "nav.skills", "Skills", "skills.ftl", "team"),
                Section("speaking", "nav.speaking", "Speaking", "speaking.ftl", "timeline"),
                Section("projects", "nav.projects", "Projects", "projects.ftl", "project"),
                Section("consulting", "nav.consulting", "Contact", "consulting.ftl", "testimonials navy-section")
        )
        val model = mapOf(
                "title" to "Marcin Moskala website",
                "languages" to languages,
                "sections" to sections,
                "careers" to career,
                "skills" to skillsVisible,
                "projects" to projetsOnMain,
                "speaking" to speaking
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