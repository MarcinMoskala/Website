package com.marcinmoskala.data

import org.junit.Assert
import org.junit.Test

class SkillFunctionsTests {
    @Test
    fun `Element with no parent is returning only himself when asked for withAllParents`() {
        for (rootSkill in skillsRoot)
            Assert.assertEquals(rootSkill, rootSkill.withAllParents)
    }
}