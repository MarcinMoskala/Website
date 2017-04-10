package com.marcinmoskala.presentation

import com.marcinmoskala.data.projetsOnMain
import kotlinx.html.div
import kotlinx.html.li
import kotlinx.html.ul
import org.jetbrains.ktor.routing.Route

fun Route.projectsRoute() {
    toHtmlResponseOnTemplate("/projects") {
        div(classes = "category") {
            +"Projects:"
            ul {
                for (proj in projetsOnMain) {
                    li { +proj.visibleName }
                    if (proj.connectedSkills.isNotEmpty()) {
                        connectedSkillsView(proj.connectedSkills)
                    }
                }
            }
        }
    }
}
