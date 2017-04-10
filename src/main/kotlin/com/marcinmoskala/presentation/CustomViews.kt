package com.marcinmoskala.presentation

import com.marcinmoskala.data.Learning
import com.marcinmoskala.data.Project
import com.marcinmoskala.data.Skill
import com.marcinmoskala.model.SkillBase
import kotlinx.html.FlowContent
import kotlinx.html.a

fun FlowContent.skillBaseView(s: SkillBase) {
    +skillPretamble(s)
    a(s.linkTo) { +s.visibleName }
    s.description?.let { +it }
}

fun skillPretamble(s: SkillBase): String = when {
    s is Project -> "Project: "
    s is Learning && s.type == Learning.Type.Book -> "Book "
    s is Learning && s.type == Learning.Type.Course -> "Course "
    else -> ""
}

fun FlowContent.connectedSkillsView(connectedSkills: List<Skill>) {
    +"Connectes skills: "
    connectedSkills.forEachIndexed { index, s ->
        if (index != 0) {
            +", "
        }
        a(s.linkTo) { +s.visibleName }
    }
}
