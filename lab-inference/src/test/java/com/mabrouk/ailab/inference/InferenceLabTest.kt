package com.mabrouk.ailab.inference

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class InferenceLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = InferenceLab.lab
        assertEquals("inference", lab.id)
        assertEquals(1, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.inference.InferenceLabActivity", lab.activityClassName)
    }
}
