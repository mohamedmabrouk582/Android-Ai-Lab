package com.mabrouk.ailab.lab

import android.content.Context

class LabProgress(context: Context) {
    private val prefs = context.applicationContext.getSharedPreferences(
        "ailab_progress",
        Context.MODE_PRIVATE,
    )

    fun passedIds(): Set<String> {
        return prefs.getStringSet(KEY, emptySet())?.toSet() ?: emptySet()
    }

    fun markPassed(id: String) {
        val updated = passedIds().toMutableSet()
        updated.add(id)
        prefs.edit().putStringSet(KEY, updated).apply()
    }

    private companion object {
        const val KEY = "passed_ids"
    }
}
