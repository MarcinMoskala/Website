package com.marcinmoskala.presentation

import com.marcinmoskala.data.Learning
import kotlinx.html.*
import org.jetbrains.ktor.routing.Route

fun Route.learningRoute() {
    toHtmlResponseOnTemplate("/learning") {
        div(classes = "category") {
            for (s in Learning.values()) {
                stepView(s)
            }
        }
    }
}

private fun FlowContent.stepView(learning: Learning) {
    section {
        id = learning.id
        h3 { +learning.visibleName }
        learning.description?.let { +it }
        if (learning.connectedSkills.isNotEmpty()) {
            connectedSkillsView(learning.connectedSkills)
        }
    }
}
