package com.mabrouk.ailab.structuredoutput

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class StructuredOutputLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(StructuredOutputLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
