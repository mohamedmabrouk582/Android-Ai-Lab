package com.mabrouk.ailab.litertruntime

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object LitertRuntimeLab {
    val lab = Lab(
        id = "litert-runtime",
        title = "Play services LiteRT and the bundled runtime",
        track = Track.Android,
        order = 19,
        summary = "Pick one runtime and know why.",
        idea = "Play services keeps the runtime out of the APK. The bundled runtime is for NPU, custom ops, or devices without Play services. One build variant contains one of them.",
        prerequisites = listOf("litert-gpu", "litert-cpu"),
        runInputs = listOf(
        "A runtime name",
        ),
        passCondition = "The screen states which artifact that choice adds and which case forbids mixing them.",
        sources = listOf(
        "https://developers.google.com/edge/litert/android/compiled_model_java",
        "https://ai.google.dev/edge/litert/android",
        ),
        activityClassName = "com.mabrouk.ailab.litertruntime.LitertRuntimeLabActivity",
    )
}
