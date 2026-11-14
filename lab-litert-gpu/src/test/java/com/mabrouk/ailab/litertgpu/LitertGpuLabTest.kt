package com.mabrouk.ailab.litertgpu

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LitertGpuLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = LitertGpuLab.lab
        assertEquals("litert-gpu", lab.id)
        assertEquals(18, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.litertgpu.LitertGpuLabActivity", lab.activityClassName)
    }
}
