package com.mabrouk.ailab.promptapi

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PromptApiLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = PromptApiLab.lab
        assertEquals("prompt-api", lab.id)
        assertEquals(14, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.promptapi.PromptApiLabActivity", lab.activityClassName)
    }
}
