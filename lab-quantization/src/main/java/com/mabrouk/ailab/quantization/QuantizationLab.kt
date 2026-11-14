package com.mabrouk.ailab.quantization

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object QuantizationLab {
    val lab = Lab(
        id = "quantization",
        title = "Quantization, latency, memory, and battery",
        track = Track.Literacy,
        order = 11,
        summary = "Size, latency, and answer quality move together.",
        idea = "Lower precision makes a model smaller and usually faster, and it can change answers.",
        prerequisites = listOf("evaluation"),
        runInputs = listOf(
        "A size in megabytes",
        "A bit width (32, 8, or 4)",
        ),
        passCondition = "The estimated smaller size follows the bit-width ratio the screen states.",
        sources = listOf(
        "https://ai.google.dev/edge/litert/android",
        ),
        activityClassName = "com.mabrouk.ailab.quantization.QuantizationLabActivity",
    )
}
