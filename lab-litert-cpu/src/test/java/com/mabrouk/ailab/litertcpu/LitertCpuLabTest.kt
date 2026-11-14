package com.mabrouk.ailab.litertcpu

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LitertCpuLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = LitertCpuLab.lab
        assertEquals("litert-cpu", lab.id)
        assertEquals(17, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.litertcpu.LitertCpuLabActivity", lab.activityClassName)
    }
}
