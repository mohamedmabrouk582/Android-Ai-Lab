package com.mabrouk.ailab.performance

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object PerformanceLab {
    val lab = Lab(
        id = "performance",
        title = "First run, heat, and the profiler",
        track = Track.Android,
        order = 25,
        summary = "Record first-run and steady-run separately.",
        idea = "The first inference includes compile and load. Later inferences show the steady cost.",
        prerequisites = listOf("camerax", "litert-gpu"),
        runInputs = listOf(
        "A repeat count",
        ),
        passCondition = "The screen shows both times and names the profiler trace to capture.",
        sources = listOf(
        "https://ai.google.dev/edge/litert/android",
        "https://developer.android.com/studio/profile",
        ),
        activityClassName = "com.mabrouk.ailab.performance.PerformanceLabActivity",
    )
}
