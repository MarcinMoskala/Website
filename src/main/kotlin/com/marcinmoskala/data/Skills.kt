package com.marcinmoskala.data

import com.marcinmoskala.data.SkillCategory.*
import com.marcinmoskala.model.Connector
import com.marcinmoskala.model.SkillBase

interface SkillTreeElement

enum class Skill(
        override val visibleName: String,
        val percentage: Int? = null,
        override val description: String = "",
        val visibleOnMain: Boolean = false,
        val category: SkillCategory? = null,
        val url: String? = null,
        val base: List<SkillBase> = listOf()
) : SkillBase, SkillTreeElement {
    Kotlin("Kotlin",
            percentage = 100,
            visibleOnMain = true,
            category = ProgrammingLanguages,
            base = listOf(Learning.KotlinInAction, Project.PreferenceHolder, Project.ActivityStarter, Project.KotlinPreferences, Project.DocplannerDoctor, Project.KotlinWonders, Project.StackTester)
    ),
    Java("Java",
            visibleOnMain = true,
            percentage = 90,
            category = ProgrammingLanguages,
            base = listOf(Learning.EffectiveJava, Learning.CleanCode, Project.WartaMobile, Project.ActivityStarter, Project.ConvictConditioning, Skill.Kotlin)
    ),
    JavaScript("JavaScript", visibleOnMain = true, percentage = 70, category = ProgrammingLanguages),
    Scala("Scala",
            visibleOnMain = true,
            percentage = 40,
            category = ProgrammingLanguages
    ),
    Matlab("Matlab",
            percentage = 40,
            category = ProgrammingLanguages
    ),
    Python("Python",
            visibleOnMain = true,
            percentage = 40,
            category = ProgrammingLanguages
    ),
    Haskell("Haskell",
            visibleOnMain = true,
            percentage = 40,
            category = ProgrammingLanguages
    ),
    Android("Android",
            category = Technologies,
            base = listOf(Project.ActivityStarter, Project.WartaMobile, Project.StackTester, Project.DocplannerDoctor, Project.KotlinPreferences, Project.PreferenceHolder, Project.ConvictConditioning)
    ),
    Spark("Spark",
            category = Technologies,
            description = "Web framework used most often for data analysis.",
            base = listOf(Project.PersonalWebsite)
    ),
    Ktor("Ktor", category = Technologies, description = "Kotlin Web framework. This website is on Ktor."),
    Gradle("Gradle", category = Technologies, description = "Java build system based on Groovy. Successor of Maven. Popular for Android."),
    ReactiveProgramming("Reactive programming", category = ProgrammingStyles),
    FunctionalProgramming("Functional programming", category = ProgrammingStyles),
    ObjectProgramming("Object programming",
            category = ProgrammingStyles,
            base = listOf(Learning.CleanCode)
    ),

    AspectProgramming("Aspect programming", category = ProgrammingStyles),
    LogicalProgramming("Logical programming", category = ProgrammingStyles),
    DeclarativeProgramming("Declarative programming",
            category = ProgrammingStyles,
            base = listOf(Project.ActivityStarter)
    ),
    DataAnalysis("Data Analysis", category = ProgrammingStyles),
    AndroidStudio("Android Studio", category = Tools),
    IDEAIntelliJ("IDEA IntelliJ", category = Tools),
    Chrome("Chrome", category = Tools),
    WritingSpeed("Writing speed", category = General),
    ;

    val id: String
        get() = name

    override val linkTo: String?
        get() = "/skills/#$id"
}

enum class SkillCategory(
        override val visibleName: String,
        val description: String? = null,
        val parent: SkillCategory? = null
) : Connector, SkillTreeElement {
    ProgrammingLanguages("Programming languages"),
    Technologies("Technologies"),
    General("General"),
    ProgrammingStyles("Programming styles"),
    Tools("Tools"),
    ;

    val id: String
        get() = name

    override val linkTo: String?
        get() = "/skills/#$id"

    val skills: List<Skill>
        get() = Skill.values().filter { it.category == this }
}

val skillsVisible: List<Skill>
    get() = Skill.values().filter { it.visibleOnMain }

val skillsRoot: List<SkillCategory>
    get() = SkillCategory.values().toList()