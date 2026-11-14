package com.mabrouk.ailab.mlkittasks

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class MlkitTasksLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(MlkitTasksLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
