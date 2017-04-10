package com.marcinmoskala.data

import com.marcinmoskala.model.SkillBase

val projetsOnMain get() = Project.values().filter { it.showOnMain }

enum class Project(
        override val visibleName: String,
        val descT: String,
        val url: String? = null,
        val img: String,
        val showOnMain: Boolean = false,
        override val description: String? = null
) : SkillBase {
    DocplannerDoctor("Docplanner Doctor App", "DocplannerDoctor", "//play.google.com/store/apps/details?id=pl.znanylekarz.lekarz", "static/img/landing/ic_launcher.png", showOnMain = true),
    WartaMobile("Warta Mobile", "WartaMobile", "//play.google.com/store/apps/details?id=pl.warta.mobile", "static/img/landing/warta.png", showOnMain = true),
    ActivityStarter("Activity Starter", "ActivityStarter", "https://github.com/MarcinMoskala/ActivityStarter", "static/img/landing/github.png", showOnMain = true),
    KotlinWonders("Kotlin Wonders", "KotlinWonders", "//github.com/MarcinMoskala/kotlinWonders", "static/img/landing/github.png", showOnMain = true),
    KotlinPreferences("KotlinPreferences", "KotlinPreferences", "https://github.com/MarcinMoskala/KotlinPreferences", "static/img/landing/github.png", showOnMain = true),
    PreferenceHolder("PreferenceHolder", "PreferenceHolder", "https://github.com/MarcinMoskala/PreferenceHolder", "static/img/landing/github.png", showOnMain = true),
    Nootro("Nootro", "Nootro", "http://nootro.pl/", "static/img/landing/nootro.png", showOnMain = true),
    StackTester("Stack Tester", "StackTester", "https://github.com/MarcinMoskala/StackTester", "static/img/landing/st.png", showOnMain = true),
    ConvictConditioning("ConvictConditioning Application", "ConvictConditioning", "https://play.google.com/store/apps/details?id=pl.marcinmoskala.activities", "static/img/landing/st.png"), // TODO
    PersonalWebsite("This website", "PersonalWebsite", "/", "static/img/landing/st.png"), // TODO
    ;

    val id: String
        get() = name

    override val linkTo get() = "/projects#$id"

    val connectedSkills: List<Skill> by lazy { Skill.values().filter { this in it.base } }
}

