package com.marcinmoskala.presentation

import com.marcinmoskala.data.Learning
import kotlinx.html.*
import io.ktor.routing.Route

fun Route.learningRoute() {

    toHtmlResponseOnTemplate("/learning") {
        showType("Books", "Books I've read", Learning.books)
        showType("Courses", "Courses I've finished", Learning.courses)
    }
}

private fun BODY.showType(id: String, header: String, items: List<Learning>) {
    section(classes = "category") {
        this.id = id
        h2 { +header }
        for (s in items) {
            learningElementView(s)
        }
    }
}

private fun FlowContent.learningElementView(learning: Learning) {
    section {
        id = learning.id
        h3 { +learning.visibleName }
        learning.description?.let { div { +"Description: $it" } }
        learning.comment?.let { div { +"Comment: $it" } }
        if (learning.connectedSkills.isNotEmpty()) {
            connectedSkillsView(learning.connectedSkills)
        }
    }
}
