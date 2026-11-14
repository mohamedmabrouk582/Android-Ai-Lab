package com.mabrouk.ailab.transformers

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TransformersLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = TransformersLab.lab
        assertEquals("transformers", lab.id)
        assertEquals(6, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.transformers.TransformersLabActivity", lab.activityClassName)
    }
}
