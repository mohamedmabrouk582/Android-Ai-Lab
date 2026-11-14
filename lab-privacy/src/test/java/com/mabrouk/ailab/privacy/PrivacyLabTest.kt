package com.mabrouk.ailab.privacy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PrivacyLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = PrivacyLab.lab
        assertEquals("privacy", lab.id)
        assertEquals(12, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.privacy.PrivacyLabActivity", lab.activityClassName)
    }
}
