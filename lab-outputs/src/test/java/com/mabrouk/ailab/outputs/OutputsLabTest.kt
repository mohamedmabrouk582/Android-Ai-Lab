package com.mabrouk.ailab.outputs

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OutputsLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = OutputsLab.lab
        assertEquals("outputs", lab.id)
        assertEquals(5, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.outputs.OutputsLabActivity", lab.activityClassName)
    }
}
