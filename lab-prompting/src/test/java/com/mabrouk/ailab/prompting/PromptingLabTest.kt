package com.mabrouk.ailab.prompting

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PromptingLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = PromptingLab.lab
        assertEquals("prompting", lab.id)
        assertEquals(7, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.prompting.PromptingLabActivity", lab.activityClassName)
    }
}
