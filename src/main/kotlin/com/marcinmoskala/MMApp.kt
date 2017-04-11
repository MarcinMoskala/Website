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
import org.jetbrains.ktor.locations.Locations
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.route
import java.io.File

class MMApp {

    fun Application.install() {
        install(DefaultHeaders)
        install(CallLogging)
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(MMApp::class.java.classLoader, "templates")
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

}