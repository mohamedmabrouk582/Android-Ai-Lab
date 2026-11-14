package com.mabrouk.ailab.ondevicerag

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OnDeviceRagLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = OnDeviceRagLab.lab
        assertEquals("on-device-rag", lab.id)
        assertEquals(21, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.ondevicerag.OnDeviceRagLabActivity", lab.activityClassName)
    }
}
