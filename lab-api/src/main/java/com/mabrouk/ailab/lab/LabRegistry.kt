package com.mabrouk.ailab.lab

object LabRegistry {
    private val registered = linkedMapOf<String, Lab>()

    fun register(lab: Lab) {
        if (registered.containsKey(lab.id)) {
            error("Duplicate lab id: ${lab.id}")
        }
        if (registered.values.any { it.order == lab.order }) {
            error("Duplicate lab order: ${lab.order}")
        }
        registered[lab.id] = lab
    }

    fun labs(): List<Lab> = registered.values.sortedBy { it.order }

    fun clearForTest() {
        registered.clear()
    }
}

fun requireFullCatalog(labs: List<Lab>) {
    check(labs.size == 28) { "Expected 28 labs, found ${labs.size}" }
    check(labs.map { it.order } == (1..28).toList()) { "Lab orders must be 1..28" }
    check(labs.map { it.id }.distinct().size == 28) { "Lab ids must be unique" }
}
