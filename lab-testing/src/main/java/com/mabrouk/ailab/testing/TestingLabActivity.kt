package com.mabrouk.ailab.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mabrouk.ailab.lab.theme.AiLabTheme
import com.mabrouk.ailab.lab.ui.LabScreen

class TestingLabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiLabTheme {
                LabScreen(TestingLab.lab)
            }
        }
    }
}
