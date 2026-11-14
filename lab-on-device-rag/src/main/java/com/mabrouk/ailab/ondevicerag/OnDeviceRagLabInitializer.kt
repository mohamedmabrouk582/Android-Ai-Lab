package com.mabrouk.ailab.ondevicerag

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class OnDeviceRagLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(OnDeviceRagLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
