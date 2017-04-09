package com.marcinmoskala.data

import com.marcinmoskala.model.Skill

val skills = listOf(
        Skill("Programming languages", subskills = listOf(
                Skill("Kotlin", percentage = 95, visibleOnMain = true, subskills = listOf(
                        Skill("Delegation", percentage = 100, subskills = listOf(
                                Skill("Property delegates", percentage = 100),
                                Skill("Class delegation", percentage = 100)
                        )),
                        Skill("Functions", percentage = 100),
                        Skill("Classes", percentage = 100),
                        Skill("Basics", percentage = 100),
                        Skill("Courtines", percentage = 0)
                )),
                Skill("Java", visibleOnMain = true, percentage = 90),
                Skill("JavaScript", visibleOnMain = true, percentage = 70),
                Skill("Scala", visibleOnMain = true, percentage = 40),
                Skill("Matlab", percentage = 40),
                Skill("Python", visibleOnMain = true, percentage = 40)

        )),
        Skill("Technologies", subskills = listOf(
                Skill("Android", visibleOnMain = true, percentage = 80, subskills = listOf(
                        Skill("RxJava", visibleOnMain = true, percentage = 60)
                )),
                Skill("Spark", description = "Web framework used most often for data analysis.", percentage = 30),
                Skill("Ktor", description = "Kotlin Web framework. This website is on Ktor.", percentage = 10),
                Skill("Gradle", description = "Java build system based on Groovy. Successor of Maven. Popular for Android. ", percentage = 40)
        )),
        Skill("Programming styles", subskills = listOf(
                Skill("Reactive programming"),
                Skill("Functional programming"),
                Skill("Object programming"),
                Skill("Aspect programming"),
                Skill("Annotation programming"),
                Skill("Logical programming"),
                Skill("Declarative programming"),
                Skill("Data Analysis")
        )),
        Skill("Tools", subskills = listOf(
                Skill("Android Studio"),
                Skill("IDEA IntelliJ"),
                Skill("Chrome"),
                Skill("General")
        )),
        Skill("General", subskills = listOf(
                Skill("Writing speed", percentage = 60),
                Skill("Operating systems", percentage = 40)
        ))
)

//- name: Docplanner Doctor Application
//url: https://play.google.com/store/apps/details?id=pl.znanylekarz.lekarz
//- name: Warta Mobile Application
//url: https://play.google.com/store/apps/details?id=pl.warta.mobile
//- name: Convict Conditioning Application
//url: https://play.google.com/store/apps/details?id=pl.marcinmoskala.activities

