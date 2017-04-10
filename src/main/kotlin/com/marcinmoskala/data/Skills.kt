package com.marcinmoskala.data

import com.marcinmoskala.model.Connector
import com.marcinmoskala.model.SkillBase

enum class Skill(
        override val visibleName: String,
        val percentage: Int? = null,
        val description: String = "",
        val visibleOnMain: Boolean = false,
        val parent: Skill? = null,
        val url: String? = null,
        val base: List<SkillBase> = listOf()
) : Connector {
    ProgrammingLanguages("Programming languages"),
    Kotlin("Kotlin",
            percentage = 100,
            visibleOnMain = true,
            parent = ProgrammingLanguages,
            base = listOf(Learning.KotlinInAction, Project.PreferenceHolder, Project.ActivityStarter, Project.KotlinPreferences, Project.DocplannerDoctor, Project.KotlinWonders, Project.StackTester)
    ),
    KotlinDelegation("Kotlin Delegation",
            percentage = 100,
            parent = Kotlin
    ),
    KotlinClassDelegation("Class delegation", percentage = 100, parent = KotlinDelegation),
    KotlinPropertyDelegates("Property delegates", percentage = 100, parent = KotlinDelegation),
    KotlinBasics("Kotlin Basics", percentage = 100, parent = Kotlin),
    KotlinFunctions("Kotlin Functions", percentage = 100, parent = Kotlin),
    KotlinClasses("Kotlin Classes", percentage = 100, parent = Kotlin),
    KotlinExtensionFunctions("Kotlin Extension Functions", percentage = 100, parent = Kotlin),
    KotlinCourtines("Kotlin Courtines", percentage = 0, parent = Kotlin),
    Java("Java",
            visibleOnMain = true,
            percentage = 90,
            parent = ProgrammingLanguages,
            base = listOf(Learning.EffectiveJava, Learning.CleanCode, Project.WartaMobile)
    ),
    JavaScript("JavaScript", visibleOnMain = true, percentage = 70, parent = ProgrammingLanguages),
    Scala("Scala", visibleOnMain = true, percentage = 40, parent = ProgrammingLanguages),
    Matlab("Matlab", percentage = 40, parent = ProgrammingLanguages),
    Python("Python", visibleOnMain = true, percentage = 40, parent = ProgrammingLanguages),
    Technologies("Technologies"),
    Android("Android",
            parent = Technologies,
            base = listOf(Project.ActivityStarter, Project.WartaMobile, Project.StackTester, Project.DocplannerDoctor, Project.KotlinPreferences, Project.PreferenceHolder, Project.ConvictConditioning)
    ),
    Spark("Spark", parent = Technologies, description = "Web framework used most often for data analysis."),
    Ktor("Ktor", parent = Technologies, description = "Kotlin Web framework. This website is on Ktor."),
    Gradle("Gradle", parent = Technologies, description = "Java build system based on Groovy. Successor of Maven. Popular for Android."),
    ProgrammingStyles("Programming styles"),
    ReactiveProgramming("Reactive programming", parent = ProgrammingStyles),
    FunctionalProgramming("Functional programming", parent = ProgrammingStyles),
    ObjectProgramming("Object programming",
            parent = ProgrammingStyles,
            base = listOf(Learning.CleanCode)
    ),

    AspectProgramming("Aspect programming", parent = ProgrammingStyles),
    LogicalProgramming("Logical programming", parent = ProgrammingStyles),
    DeclarativeProgramming("Declarative programming",
            parent = ProgrammingStyles,
            base = listOf(Project.ActivityStarter)
    ),
    DataAnalysis("Data Analysis", parent = ProgrammingStyles),
    Tools("Tools"),
    AndroidStudio("Android Studio", parent = Tools),
    IDEAIntelliJ("IDEA IntelliJ", parent = Tools),
    Chrome("Chrome", parent = Tools),
    General("General"),
    WritingSpeed("Writing speed", parent = General),
    ;

    val id: String
        get() = name

    override val linkTo: String?
        get() = "/skills/#$id"

    val subskills: List<Skill>
        get() = values().filter { it.parent == this }

    val withAllParents: List<Skill>
        get() = parent?.withAllParents.orEmpty() + this
}

val skillsVisible: List<Skill>
    get() = Skill.values().filter { it.visibleOnMain }

val skillsRoot: List<Skill>
    get() = Skill.values().filter { it.parent == null }