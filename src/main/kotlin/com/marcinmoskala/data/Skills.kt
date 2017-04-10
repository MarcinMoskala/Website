package com.marcinmoskala.data

import com.marcinmoskala.model.Connector

enum class Skill(
        override val visibleName: String,
        val percentage: Int? = null,
        val description: String = "",
        val visibleOnMain: Boolean = false,
        val subskills: List<Skill> = listOf(),
        val base: List<Connector> = listOf(),
        val parent: Skill? = null,
        val url: String? = null
): Connector {
    ProgrammingLanguages("Programming languages"),
    Kotlin("Kotlin", percentage = 95, visibleOnMain = true, parent = ProgrammingLanguages),
    KotlinDelegation("Kotlin Delegation", percentage = 100, parent = Kotlin),
    KotlinClassDelegation("Class delegation", percentage = 100, parent = KotlinDelegation),
    KotlinPropertyDelegates("Property delegates", percentage = 100, parent = KotlinDelegation),
    KotlinBasics("Kotlin Basics", percentage = 100, parent = Kotlin),
    KotlinFunctions("Kotlin Functions", percentage = 100, parent = Kotlin),
    KotlinClasses("Kotlin Classes", percentage = 100, parent = Kotlin),
    KotlinExtensionFunctions("Kotlin Extension Functions", percentage = 100, parent = Kotlin),
    KotlinCourtines("Kotlin Courtines", percentage = 0, parent = Kotlin),
    Java("Java", visibleOnMain = true, percentage = 90, parent = ProgrammingLanguages),
    JavaScript("JavaScript", visibleOnMain = true, percentage = 70, parent = ProgrammingLanguages),
    Scala("Scala", visibleOnMain = true, percentage = 40, parent = ProgrammingLanguages),
    Matlab("Matlab", percentage = 40, parent = ProgrammingLanguages),
    Python("Python", visibleOnMain = true, percentage = 40, parent = ProgrammingLanguages)    ;

    val id: String get() = name
    override val linkTo: String?
        get() = ""
}

val skills = Skill.values().filter { it.visibleOnMain }
//        Skill("Technologies", subskills = listOf(
//                Skill("Android", visibleOnMain = true, percentage = 80, subskills = listOf(
//                        Skill("RxJava", visibleOnMain = true, percentage = 60)
//                )),
//                Skill("Spark", description = "Web framework used most often for data analysis.", percentage = 30),
//                Skill("Ktor", description = "Kotlin Web framework. This website is on Ktor.", percentage = 10),
//                Skill("Gradle", description = "Java build system based on Groovy. Successor of Maven. Popular for Android. ", percentage = 40)
//        )),
//        Skill("Programming styles", subskills = listOf(
//                Skill("Reactive programming"),
//                Skill("Functional programming"),
//                Skill("Object programming"),
//                Skill("Aspect programming"),
//                Skill("Annotation programming"),
//                Skill("Logical programming"),
//                Skill("Declarative programming"),
//                Skill("Data Analysis")
//        )),
//        Skill("Tools", subskills = listOf(
//                Skill("Android Studio"),
//                Skill("IDEA IntelliJ"),
//                Skill("Chrome"),
//                Skill("General")
//        )),
//        Skill("General", subskills = listOf(
//                Skill("Writing speed", percentage = 60),
//                Skill("Operating systems", percentage = 40)
//        ))
//)
//
////- name: Docplanner Doctor Application
////url: https://play.google.com/store/apps/details?id=pl.znanylekarz.lekarz
////- name: Warta Mobile Application
////url: https://play.google.com/store/apps/details?id=pl.warta.mobile
////- name: Convict Conditioning Application
////url: https://play.google.com/store/apps/details?id=pl.marcinmoskala.activities
//
