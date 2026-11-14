package com.mabrouk.ailab.litertruntime

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class LitertRuntimeLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(LitertRuntimeLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
