package com.mabrouk.ailab.tensors

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class TensorsLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(TensorsLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
