package com.mabrouk.ailab.performance

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class PerformanceLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(PerformanceLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
