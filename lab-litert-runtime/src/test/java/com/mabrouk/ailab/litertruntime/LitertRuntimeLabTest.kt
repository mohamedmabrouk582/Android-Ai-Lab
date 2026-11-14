package com.mabrouk.ailab.litertruntime

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LitertRuntimeLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = LitertRuntimeLab.lab
        assertEquals("litert-runtime", lab.id)
        assertEquals(19, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.litertruntime.LitertRuntimeLabActivity", lab.activityClassName)
    }
}
