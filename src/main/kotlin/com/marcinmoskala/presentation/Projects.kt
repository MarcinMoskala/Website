package com.marcinmoskala.presentation

import com.marcinmoskala.data.projets
import kotlinx.html.li
import kotlinx.html.ul
import org.jetbrains.ktor.routing.Route

fun Route.projectsRoute() {
    toHtmlResponseOnTemplate("/projects") {
        +"Projects:"
        ul {
            for (s in projets) {
                li { +s.name }
            }
        }
    }
}