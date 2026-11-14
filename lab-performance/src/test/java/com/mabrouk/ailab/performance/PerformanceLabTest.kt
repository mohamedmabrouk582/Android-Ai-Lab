package com.mabrouk.ailab.performance

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PerformanceLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = PerformanceLab.lab
        assertEquals("performance", lab.id)
        assertEquals(25, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.performance.PerformanceLabActivity", lab.activityClassName)
    }
}
