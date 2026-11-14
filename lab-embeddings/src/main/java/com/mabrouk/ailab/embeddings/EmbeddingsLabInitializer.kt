package com.mabrouk.ailab.embeddings

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class EmbeddingsLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(EmbeddingsLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
