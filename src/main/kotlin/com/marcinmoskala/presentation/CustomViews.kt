package com.marcinmoskala.presentation

import com.marcinmoskala.data.Skill
import com.marcinmoskala.model.SkillBase
import kotlinx.html.FlowContent
import kotlinx.html.a

fun FlowContent.skillBaseView(s: SkillBase) {
    a(s.linkTo) { +s.visibleName }
    s.description?.let { +it }
    s.complition?.let { +it }
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
