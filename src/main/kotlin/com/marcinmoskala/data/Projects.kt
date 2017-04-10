package com.marcinmoskala.data

import com.marcinmoskala.model.SkillBase

val projets get() = Project.values()

enum class Project(
        override val visibleName: String,
        val descT: String,
        val url: String,
        val img: String,
        override val description: String? = null,
        override val complition: String? = null
) : SkillBase {
    DocplannerDoctor("Docplanner Doctor App", "DocplannerDoctor", "//play.google.com/store/apps/details?id=pl.znanylekarz.lekarz", "static/img/landing/ic_launcher.png"),
    WartaMobile("Warta Mobile", "WartaMobile", "//play.google.com/store/apps/details?id=pl.warta.mobile", "static/img/landing/warta.png"),
    ActivityStarter("Activity Starter", "ActivityStarter", "https://github.com/MarcinMoskala/ActivityStarter", "static/img/landing/github.png"),
    KotlinWonders("Kotlin Wonders", "KotlinWonders", "//github.com/MarcinMoskala/kotlinWonders", "static/img/landing/github.png"),
    KotlinPreferences("KotlinPreferences", "KotlinPreferences", "https://github.com/MarcinMoskala/KotlinPreferences", "static/img/landing/github.png"),
    PreferenceHolder("PreferenceHolder", "PreferenceHolder", "https://github.com/MarcinMoskala/PreferenceHolder", "static/img/landing/github.png"),
    Nootro("Nootro", "Nootro", "http://nootro.pl/", "static/img/landing/nootro.png"),
    StackTester("Stack Tester", "StackTester", "https://github.com/MarcinMoskala/StackTester", "static/img/landing/st.png"),
    ConvictConditioning("ConvictConditioning Application", "StackTester", "https://play.google.com/store/apps/details?id=pl.marcinmoskala.activities", "static/img/landing/st.png"), // TODO
    ;

    val id: String
        get() = name

    override val linkTo get() = "/projects#$id"

    val connectedSkills: List<Skill> by lazy { Skill.values().filter { this in it.base } }
}

