package com.mabrouk.ailab.embeddings

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EmbeddingsLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = EmbeddingsLab.lab
        assertEquals("embeddings", lab.id)
        assertEquals(4, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.embeddings.EmbeddingsLabActivity", lab.activityClassName)
    }
}
