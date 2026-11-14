package com.mabrouk.ailab.speech

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SpeechLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = SpeechLab.lab
        assertEquals("speech", lab.id)
        assertEquals(23, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.speech.SpeechLabActivity", lab.activityClassName)
    }
}
