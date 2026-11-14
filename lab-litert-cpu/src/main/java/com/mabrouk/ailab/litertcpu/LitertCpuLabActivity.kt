package com.mabrouk.ailab.litertcpu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mabrouk.ailab.lab.theme.AiLabTheme
import com.mabrouk.ailab.lab.ui.LabScreen

class LitertCpuLabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiLabTheme {
                LabScreen(LitertCpuLab.lab)
            }
        }
    }
}
