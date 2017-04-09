package com.marcinmoskala.presentation

import com.marcinmoskala.data.skills
import com.marcinmoskala.model.Skill
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
                for(s in skills) {
                    skillView(s)
                }
            }
        }
    }
}

fun FlowContent.skillView(skill: Skill) {
    div {
        h3 { +skill.name }
        +skill.description
        if(skill.subskills.isNotEmpty())
        ul {
            for(s in skill.subskills) {
                li {
                    skillView(s)
                }
            }
        }
    }
}
