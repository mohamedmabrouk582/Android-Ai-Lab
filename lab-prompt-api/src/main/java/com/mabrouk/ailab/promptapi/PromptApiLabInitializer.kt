package com.mabrouk.ailab.promptapi

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class PromptApiLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(PromptApiLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
