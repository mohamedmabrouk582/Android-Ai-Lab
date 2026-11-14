package com.mabrouk.ailab

import android.app.Application
import com.mabrouk.ailab.lab.LabRegistry
import com.mabrouk.ailab.lab.requireFullCatalog

class AiLabApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        requireFullCatalog(LabRegistry.labs())
    }
}
