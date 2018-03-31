package com.marcinmoskala

import com.marcinmoskala.presentation.indexRoute
import com.marcinmoskala.presentation.learningRoute
import com.marcinmoskala.presentation.projectsRoute
import com.marcinmoskala.presentation.skillsRoute
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.content.resources
import io.ktor.content.staticRootFolder
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.freemarker.FreeMarker
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import io.ktor.routing.route
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
                staticRootFolder = File("src/main/resources/")
                resources("static")
            }
        }
    }

}