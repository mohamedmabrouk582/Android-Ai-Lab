package com.mabrouk.ailab.quantization

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class QuantizationLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = QuantizationLab.lab
        assertEquals("quantization", lab.id)
        assertEquals(11, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.quantization.QuantizationLabActivity", lab.activityClassName)
    }
}
