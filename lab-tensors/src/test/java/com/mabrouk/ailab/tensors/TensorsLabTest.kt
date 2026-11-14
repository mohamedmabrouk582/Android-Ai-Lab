package com.mabrouk.ailab.tensors

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TensorsLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = TensorsLab.lab
        assertEquals("tensors", lab.id)
        assertEquals(2, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.tensors.TensorsLabActivity", lab.activityClassName)
    }
}
