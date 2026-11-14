package com.mabrouk.ailab.litertgpu

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class LitertGpuLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(LitertGpuLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
