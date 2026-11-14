package com.mabrouk.ailab.appfunctions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppfunctionsLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = AppfunctionsLab.lab
        assertEquals("appfunctions", lab.id)
        assertEquals(26, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.appfunctions.AppfunctionsLabActivity", lab.activityClassName)
    }
}
