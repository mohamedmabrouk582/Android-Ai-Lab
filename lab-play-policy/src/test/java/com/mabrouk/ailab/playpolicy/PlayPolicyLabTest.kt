package com.mabrouk.ailab.playpolicy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PlayPolicyLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = PlayPolicyLab.lab
        assertEquals("play-policy", lab.id)
        assertEquals(28, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.playpolicy.PlayPolicyLabActivity", lab.activityClassName)
    }
}
