package com.mabrouk.ailab.mlkittasks

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object MlkitTasksLab {
    val lab = Lab(
        id = "mlkit-tasks",
        title = "ML Kit task APIs",
        track = Track.Android,
        order = 13,
        summary = "Call a task API before you ship a custom model.",
        idea = "Text recognition, barcode, face, and pose are ready-made models with a task API.",
        prerequisites = listOf("privacy"),
        runInputs = listOf(
        "A task name",
        ),
        passCondition = "The screen lists what that task returns (text, a code, faces, or landmarks).",
        sources = listOf(
        "https://developers.google.com/ml-kit/vision",
        ),
        activityClassName = "com.mabrouk.ailab.mlkittasks.MlkitTasksLabActivity",
    )
}
