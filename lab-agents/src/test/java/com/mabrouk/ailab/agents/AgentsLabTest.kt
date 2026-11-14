package com.mabrouk.ailab.agents

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AgentsLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = AgentsLab.lab
        assertEquals("agents", lab.id)
        assertEquals(9, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.agents.AgentsLabActivity", lab.activityClassName)
    }
}
