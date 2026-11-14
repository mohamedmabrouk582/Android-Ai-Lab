package com.mabrouk.ailab.lab

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class LabRegistryTest {
    @Test
    fun register_sortsByOrder() {
        LabRegistry.clearForTest()
        LabRegistry.register(fake(order = 2, id = "b"))
        LabRegistry.register(fake(order = 1, id = "a"))
        assertEquals(listOf("a", "b"), LabRegistry.labs().map { it.id })
    }

    @Test
    fun register_rejectsDuplicateId() {
        LabRegistry.clearForTest()
        LabRegistry.register(fake(order = 1, id = "a"))
        assertThrows(IllegalStateException::class.java) {
            LabRegistry.register(fake(order = 2, id = "a"))
        }
    }

    @Test
    fun register_rejectsDuplicateOrder() {
        LabRegistry.clearForTest()
        LabRegistry.register(fake(order = 1, id = "a"))
        assertThrows(IllegalStateException::class.java) {
            LabRegistry.register(fake(order = 1, id = "b"))
        }
    }

    @Test
    fun clearForTest_allowsTheSameIdAgain() {
        LabRegistry.clearForTest()
        LabRegistry.register(fake(order = 1, id = "a"))
        LabRegistry.clearForTest()
        LabRegistry.register(fake(order = 1, id = "a"))
        assertEquals(listOf("a"), LabRegistry.labs().map { it.id })
    }

    @Test
    fun requireFullCatalog_acceptsOrdersOneThroughTwentyEight() {
        val labs = (1..28).map { fake(order = it, id = "lab-$it") }
        requireFullCatalog(labs)
    }

    @Test
    fun requireFullCatalog_rejectsTwentySevenLabs() {
        val labs = (1..27).map { fake(order = it, id = "lab-$it") }
        assertThrows(IllegalStateException::class.java) {
            requireFullCatalog(labs)
        }
    }
}

private fun fake(order: Int, id: String) = Lab(
    id = id,
    title = id,
    track = Track.Literacy,
    order = order,
    summary = "summary",
    idea = "idea",
    prerequisites = emptyList(),
    runInputs = listOf("input"),
    passCondition = "pass",
    sources = listOf("https://example.com"),
    activityClassName = "com.example.LabActivity",
)
