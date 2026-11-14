package com.mabrouk.ailab.privacy

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class PrivacyLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(PrivacyLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
