package com.mabrouk.ailab.speech

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class SpeechLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(SpeechLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
