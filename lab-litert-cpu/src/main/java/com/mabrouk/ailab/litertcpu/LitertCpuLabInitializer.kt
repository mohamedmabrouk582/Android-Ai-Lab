package com.mabrouk.ailab.litertcpu

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class LitertCpuLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(LitertCpuLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
