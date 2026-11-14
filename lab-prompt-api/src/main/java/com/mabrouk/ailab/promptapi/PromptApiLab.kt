package com.mabrouk.ailab.promptapi

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object PromptApiLab {
    val lab = Lab(
        id = "prompt-api",
        title = "Gemini Nano Prompt API",
        track = Track.Android,
        order = 14,
        summary = "Ask Gemini Nano only after the feature is available.",
        idea = "Check FeatureStatus, download when the model is downloadable, stream or wait, and close() the client. The model is unavailable on some phones, including unlocked bootloaders.",
        prerequisites = listOf("mlkit-tasks"),
        runInputs = listOf(
        "One prompt",
        ),
        passCondition = "The status is shown, and a missing model stays on an explanation screen without a passed check.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai/prompt/android/get-started",
        "https://developers.google.com/ml-kit/genai/prompt/android",
        ),
        activityClassName = "com.mabrouk.ailab.promptapi.PromptApiLabActivity",
    )
}
