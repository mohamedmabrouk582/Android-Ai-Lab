package com.mabrouk.ailab.camerax

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CameraxLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = CameraxLab.lab
        assertEquals("camerax", lab.id)
        assertEquals(24, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.camerax.CameraxLabActivity", lab.activityClassName)
    }
}
