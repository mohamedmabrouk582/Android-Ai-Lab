package com.mabrouk.ailab.agents

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class AgentsLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(AgentsLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
