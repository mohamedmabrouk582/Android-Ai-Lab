package com.mabrouk.ailab.transformers

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class TransformersLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(TransformersLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
