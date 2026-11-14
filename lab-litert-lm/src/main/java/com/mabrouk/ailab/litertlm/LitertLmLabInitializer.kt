package com.mabrouk.ailab.litertlm

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class LitertLmLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(LitertLmLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
