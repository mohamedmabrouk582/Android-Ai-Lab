package com.mabrouk.ailab.litertlm

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LitertLmLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = LitertLmLab.lab
        assertEquals("litert-lm", lab.id)
        assertEquals(22, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.litertlm.LitertLmLabActivity", lab.activityClassName)
    }
}
