package com.mabrouk.ailab.quantization

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class QuantizationLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(QuantizationLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
