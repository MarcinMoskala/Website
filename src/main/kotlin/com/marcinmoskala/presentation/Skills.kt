package com.marcinmoskala.presentation

import com.marcinmoskala.data.Skill
import com.marcinmoskala.data.skillsRoot
import kotlinx.html.*
import org.jetbrains.ktor.routing.Route

fun Route.skillsRoute() {
    toHtmlResponseOnTemplate("/skills") {
        for (s in skillsRoot) {
            skillView(s)
        }
    }
}

private fun FlowContent.skillView(skill: Skill) {
    section {
        id = skill.id
        h3 { +skill.name }
        +skill.description
        if (skill.base.isNotEmpty()) {
            +"Skill base:"
            ul {
                skill.base.forEach { s -> li { skillBaseView(s) } }
            }
        }
        if (skill.subskills.isNotEmpty()) {
            ul {
                skill.subskills.forEach { s -> li { skillView(s) } }
            }
        }
    }
}