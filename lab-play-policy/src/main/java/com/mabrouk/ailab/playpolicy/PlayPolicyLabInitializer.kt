package com.mabrouk.ailab.playpolicy

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class PlayPolicyLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(PlayPolicyLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
