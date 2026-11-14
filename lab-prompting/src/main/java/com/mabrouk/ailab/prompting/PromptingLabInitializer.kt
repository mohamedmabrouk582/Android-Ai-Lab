package com.mabrouk.ailab.prompting

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class PromptingLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(PromptingLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
