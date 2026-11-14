package com.mabrouk.ailab.evaluation

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EvaluationLabTest {
    @Test
    fun lab_matchesTheCatalogContract() {
        val lab = EvaluationLab.lab
        assertEquals("evaluation", lab.id)
        assertEquals(10, lab.order)
        assertTrue(lab.idea.isNotBlank())
        assertTrue(lab.runInputs.isNotEmpty())
        assertTrue(lab.passCondition.isNotBlank())
        assertTrue(lab.sources.all { it.startsWith("https://") })
        assertEquals("com.mabrouk.ailab.evaluation.EvaluationLabActivity", lab.activityClassName)
    }
}
