package com.mabrouk.ailab.genaitasks

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class GenaiTasksLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(GenaiTasksLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
