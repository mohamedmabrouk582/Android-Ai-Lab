package com.mabrouk.ailab.ondevicerag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mabrouk.ailab.lab.theme.AiLabTheme
import com.mabrouk.ailab.lab.ui.LabScreen

class OnDeviceRagLabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiLabTheme {
                LabScreen(OnDeviceRagLab.lab)
            }
        }
    }
}
