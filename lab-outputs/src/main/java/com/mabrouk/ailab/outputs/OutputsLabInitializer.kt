package com.mabrouk.ailab.outputs

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class OutputsLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(OutputsLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
