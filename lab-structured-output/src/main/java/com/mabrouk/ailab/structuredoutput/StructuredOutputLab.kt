package com.mabrouk.ailab.structuredoutput

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object StructuredOutputLab {
    val lab = Lab(
        id = "structured-output",
        title = "Structured output and prefix caching",
        track = Track.Android,
        order = 15,
        summary = "Parse a typed object, and cache the stable prefix.",
        idea = "A Kotlin type is the response contract. A repeated prefix can be cached apart from the changing suffix.",
        prerequisites = listOf("prompt-api"),
        runInputs = listOf(
        "A prefix",
        "A suffix",
        ),
        passCondition = "The screen shows a typed object, and the prefix is marked as the cached part.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai/prompt/android/structured-output",
        "https://developer.android.com/agents/skills/device-ai/ml-kit-genai-prompt-api/references/prefix-caching",
        ),
        activityClassName = "com.mabrouk.ailab.structuredoutput.StructuredOutputLabActivity",
    )
}
