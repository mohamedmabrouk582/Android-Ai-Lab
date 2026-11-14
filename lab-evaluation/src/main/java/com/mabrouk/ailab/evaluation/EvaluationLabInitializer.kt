package com.mabrouk.ailab.evaluation

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class EvaluationLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(EvaluationLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
