package com.mabrouk.ailab.rag

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class RagLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(RagLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
