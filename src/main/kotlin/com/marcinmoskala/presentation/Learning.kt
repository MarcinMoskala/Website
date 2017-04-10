package com.marcinmoskala.presentation

import com.marcinmoskala.data.Learning
import kotlinx.html.FlowContent
import kotlinx.html.h3
import kotlinx.html.id
import kotlinx.html.section
import org.jetbrains.ktor.routing.Route

fun Route.stepsRoute() {
    toHtmlResponseOnTemplate("/steps") {
        for (s in Learning.values()) {
            stepView(s)
        }
    }
}

private fun FlowContent.stepView(learning: Learning) {
    section {
        id = learning.id
        h3 { +learning.name }
        learning.description?.let { +it }
        if (learning.connectedSkills.isNotEmpty()) {
            connectedSkillsView(learning.connectedSkills)
        }
    }
}
