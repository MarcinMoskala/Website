package com.marcinmoskala.presentation

import com.marcinmoskala.data.*
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.freemarker.FreeMarkerContent
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.indexRoute() {
    get("/") {
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
                "skills" to skills,
                "projects" to projets,
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