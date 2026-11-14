package com.mabrouk.ailab.modeldelivery

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class ModelDeliveryLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(ModelDeliveryLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
