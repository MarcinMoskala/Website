package com.marcinmoskala

import com.marcinmoskala.presentation.indexRoute
import com.marcinmoskala.presentation.learningRoute
import com.marcinmoskala.presentation.projectsRoute
import com.marcinmoskala.presentation.skillsRoute
import freemarker.cache.ClassTemplateLoader
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.content.serveFileSystem
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.freemarker.FreeMarker
import org.jetbrains.ktor.host.embeddedServer
import org.jetbrains.ktor.locations.Locations
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.netty.Netty
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.route
import java.io.File

fun Application.install() {
    install(DefaultHeaders)
    install(CallLogging)
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(environment.classLoader, "templates")
    }

    install(Locations)
    install(Routing) {
        indexRoute()
        skillsRoute()
        projectsRoute()
        learningRoute()
        route("static") {
            serveFileSystem(File("src/main/resources/static"))
        }
    }
}


fun main(args: Array<String>) {
    val port = Integer.valueOf(System.getenv("PORT") ?: "8080")
    embeddedServer(Netty, port, reloadPackages = listOf("heroku"), module = Application::install).start()
}
