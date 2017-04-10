package com.marcinmoskala.presentation

import kotlinx.html.*
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.html.respondHtml
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.toHtmlResponseOnTemplate(path: String, function: BODY.() -> Unit) {
    get(path) {
        call.respondHtml {
            head {
                title { +"Marcin Moskala Website" }
                styleLink("/static/css/list.css")
            }
            body {
                function()
            }
        }
    }
}
