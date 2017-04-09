package com.marcinmoskala.presentation

import kotlinx.html.BODY
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.title
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.html.respondHtml
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.toHtmlResponseOnTemplate(path: String, function: BODY.() -> Unit) {
    get(path) {
        call.respondHtml {
            head {
                title { +"Marcin Moskala Website" }
            }
            body {
                function()
            }
        }
    }
}
