package com.mabrouk.ailab.litertgpu

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object LitertGpuLab {
    val lab = Lab(
        id = "litert-gpu",
        title = "GPU, one thread, warm-up, and latency",
        track = Track.Android,
        order = 18,
        summary = "Time the steady run, and keep the model on one thread.",
        idea = "One background thread owns the model. GPU options list CPU as the fallback. Measure run together with the output read. Warm up once so the first user tap is not the shader compile.",
        prerequisites = listOf("litert-cpu"),
        runInputs = listOf(
        "A repeat count",
        ),
        passCondition = "The screen shows a warm-up time and a steady-run time.",
        sources = listOf(
        "https://ai.google.dev/edge/litert/android",
        ),
        activityClassName = "com.mabrouk.ailab.litertgpu.LitertGpuLabActivity",
    )
}
