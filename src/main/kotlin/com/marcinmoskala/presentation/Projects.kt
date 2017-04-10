package com.marcinmoskala.presentation

import com.marcinmoskala.data.projets
import kotlinx.html.li
import kotlinx.html.ul
import org.jetbrains.ktor.routing.Route

fun Route.projectsRoute() {
    toHtmlResponseOnTemplate("/projects") {
        +"Projects:"
        ul {
            for (proj in projets) {
                li { +proj.visibleName }
                if (proj.connectedSkills.isNotEmpty()) {
                    connectedSkillsView(proj.connectedSkills)
                }
            }
        }
    }
}
