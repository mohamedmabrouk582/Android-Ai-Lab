package com.mabrouk.ailab

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.LabProgress
import com.mabrouk.ailab.lab.LabRegistry
import com.mabrouk.ailab.lab.Track

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val labs = LabRegistry.labs()
    val passed = LabProgress(context).passedIds()
    val nextOrder = labs.firstOrNull { it.id !in passed }?.order
    var missingMessage by remember { mutableStateOf("") }
    Scaffold(
        topBar = { TopAppBar(title = { Text("Ai Lab") }) },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            if (missingMessage.isNotEmpty()) {
                item {
                    Text(
                        text = missingMessage,
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.error,
                    )
                }
            }
            item { SectionTitle("Track 1. AI literacy") }
            items(labs.filter { it.track == Track.Literacy }, key = { it.id }) { lab ->
                LabRow(lab, passed, nextOrder) { missingMessage = openLab(context, lab) }
            }
            item { SectionTitle("Track 2. Android labs") }
            items(labs.filter { it.track == Track.Android }, key = { it.id }) { lab ->
                LabRow(lab, passed, nextOrder) { missingMessage = openLab(context, lab) }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
    )
}

@Composable
private fun LabRow(
    lab: Lab,
    passed: Set<String>,
    nextOrder: Int?,
    onOpen: () -> Unit,
) {
    val badge = when {
        lab.id in passed -> "Done"
        lab.order == nextOrder -> "Next"
        else -> ""
    }
    ListItem(
        headlineContent = { Text("${lab.order}. ${lab.title}") },
        supportingContent = { Text(lab.summary) },
        trailingContent = { if (badge.isNotEmpty()) Text(badge) },
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onOpen),
    )
    HorizontalDivider()
}

private fun openLab(context: android.content.Context, lab: Lab): String {
    try {
        val type = Class.forName(lab.activityClassName)
        if (!Activity::class.java.isAssignableFrom(type)) {
            return "This lab is not installed."
        }
        context.startActivity(Intent(context, type))
        return ""
    } catch (_: ClassNotFoundException) {
        return "This lab is not installed."
    }
}
