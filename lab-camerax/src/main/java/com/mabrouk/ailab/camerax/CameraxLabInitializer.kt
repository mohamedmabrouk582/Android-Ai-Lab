package com.mabrouk.ailab.camerax

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class CameraxLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(CameraxLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
