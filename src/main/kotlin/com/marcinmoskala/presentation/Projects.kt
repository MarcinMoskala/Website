package com.marcinmoskala.presentation

import com.marcinmoskala.data.projetsOnMain
import kotlinx.html.*
import io.ktor.routing.Route

fun Route.projectsRoute() {
    toHtmlResponseOnTemplate("/projects") {
        div(classes = "category") {
            h2 { +"Projects:" }
            for (proj in projetsOnMain) {
                section {
                    id = proj.id
                    h3 { +proj.visibleName }
                    proj.url?.let { div { a(it) { +"Link" } } }
                    if (proj.connectedSkills.isNotEmpty()) {
                        div { connectedSkillsView(proj.connectedSkills) }
                    }
                }
            }
        }
    }
}
