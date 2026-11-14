package com.mabrouk.ailab.inference

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class InferenceLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(InferenceLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
