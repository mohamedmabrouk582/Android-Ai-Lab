package com.mabrouk.ailab.modeldelivery

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ModelDeliveryLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = ModelDeliveryLab.lab
        assertEquals("model-delivery", lab.id)
        assertEquals(20, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.modeldelivery.ModelDeliveryLabActivity", lab.activityClassName)
    }
}
