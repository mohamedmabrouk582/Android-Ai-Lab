package com.mabrouk.ailab.lab.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.LabRegistry
import com.mabrouk.ailab.lab.Track

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabScreen(lab: Lab) {
    val suggested = lab.prerequisites.map { id ->
        LabRegistry.labs().firstOrNull { it.id == id }?.title ?: id
    }
    Scaffold(
        topBar = { TopAppBar(title = { Text(lab.title) }) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = if (lab.track == Track.Literacy) "Track 1. AI literacy" else "Track 2. Android labs",
                style = MaterialTheme.typography.labelLarge,
            )
            Text(text = "Topic ${lab.order}", style = MaterialTheme.typography.bodyMedium)
            if (suggested.isNotEmpty()) {
                Text(text = "Suggested after: ${suggested.joinToString(", ")}")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Idea", style = MaterialTheme.typography.titleMedium)
            Text(text = lab.idea)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Run", style = MaterialTheme.typography.titleMedium)
            lab.runInputs.forEach { input ->
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    enabled = false,
                    label = { Text(input) },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Button(onClick = {}, enabled = false) { Text("Run") }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Check", style = MaterialTheme.typography.titleMedium)
            Text(text = lab.passCondition)
            Button(onClick = {}, enabled = false) { Text("Check") }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "The interactive bench for this topic is not built yet.")
        }
    }
}
