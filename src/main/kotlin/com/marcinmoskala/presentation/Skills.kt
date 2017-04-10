package com.marcinmoskala.presentation

import com.marcinmoskala.data.Skill
import com.marcinmoskala.data.skills
import kotlinx.html.*
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.html.respondHtml
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.skillsRoute() {
    get("/skills") {
        call.respondHtml {
            head {
                title { +"HTML Application" }
            }
            body {
                for (s in skills) {
                    skillView(s)
                }
            }
        }
    }
}

private fun FlowContent.skillView(skill: Skill) {
    section {
        id = skill.id
        h3 { +skill.name }
        +skill.description
        if (skill.subskills.isNotEmpty()) {
            ul {
                skill.subskills.forEach { s -> li { skillView(s) } }
            }
        }
    }
}
