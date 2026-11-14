package com.mabrouk.ailab.tokens

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TokensLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = TokensLab.lab
        assertEquals("tokens", lab.id)
        assertEquals(3, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.tokens.TokensLabActivity", lab.activityClassName)
    }
}
