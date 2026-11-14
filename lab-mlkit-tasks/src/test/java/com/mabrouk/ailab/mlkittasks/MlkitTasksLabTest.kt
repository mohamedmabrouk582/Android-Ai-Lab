package com.mabrouk.ailab.mlkittasks

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MlkitTasksLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = MlkitTasksLab.lab
        assertEquals("mlkit-tasks", lab.id)
        assertEquals(13, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.mlkittasks.MlkitTasksLabActivity", lab.activityClassName)
    }
}
