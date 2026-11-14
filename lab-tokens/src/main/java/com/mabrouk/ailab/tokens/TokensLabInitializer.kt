package com.mabrouk.ailab.tokens

import android.content.Context
import androidx.startup.Initializer
import com.mabrouk.ailab.lab.LabRegistry

class TokensLabInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        LabRegistry.register(TokensLab.lab)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
