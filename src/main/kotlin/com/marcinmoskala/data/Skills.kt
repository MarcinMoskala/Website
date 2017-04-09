package com.marcinmoskala.data

import com.marcinmoskala.model.Skill

val skills = listOf(
        Skill("Kotlin", percentage = 95, subskills = listOf(
                Skill("Delegation", percentage = 100, subskills = listOf(
                        Skill("Property delegates", percentage = 100),
                        Skill("Class delegation", percentage = 100)
                )),
                Skill("Functions", percentage = 100),
                Skill("Classes", percentage = 100),
                Skill("Basics", percentage = 100),
                Skill("Courtines", percentage = 0)
        )),
        Skill("Java", percentage = 90),
        Skill("Android", percentage = 80),
        Skill("RxJava", percentage = 60),
        Skill("Scala", percentage = 40),
        Skill("Python", percentage = 30)
)
