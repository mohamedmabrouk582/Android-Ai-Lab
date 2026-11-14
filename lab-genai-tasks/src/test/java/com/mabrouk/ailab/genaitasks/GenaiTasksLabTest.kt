package com.mabrouk.ailab.genaitasks

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GenaiTasksLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = GenaiTasksLab.lab
        assertEquals("genai-tasks", lab.id)
        assertEquals(16, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.genaitasks.GenaiTasksLabActivity", lab.activityClassName)
    }
}
