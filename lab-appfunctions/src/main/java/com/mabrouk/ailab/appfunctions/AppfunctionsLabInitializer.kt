package com.mabrouk.ailab.appfunctions

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class AppfunctionsLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(AppfunctionsLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
