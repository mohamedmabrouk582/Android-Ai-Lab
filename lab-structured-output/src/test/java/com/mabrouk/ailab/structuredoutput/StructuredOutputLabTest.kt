package com.mabrouk.ailab.structuredoutput

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StructuredOutputLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = StructuredOutputLab.lab
        assertEquals("structured-output", lab.id)
        assertEquals(15, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.structuredoutput.StructuredOutputLabActivity", lab.activityClassName)
    }
}
