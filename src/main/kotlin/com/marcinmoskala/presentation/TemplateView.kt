package com.marcinmoskala.presentation

import kotlinx.html.*
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get

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
