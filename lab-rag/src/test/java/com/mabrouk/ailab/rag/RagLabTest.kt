package com.mabrouk.ailab.rag

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RagLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = RagLab.lab
        assertEquals("rag", lab.id)
        assertEquals(8, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.rag.RagLabActivity", lab.activityClassName)
    }
}
