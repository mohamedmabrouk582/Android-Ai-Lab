package com.mabrouk.ailab.prompting

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object PromptingLab {
    val lab = Lab(
        id = "prompting",
        title = "Prompting and structured output",
        track = Track.Literacy,
        order = 7,
        summary = "Ask for a shape, not only a paragraph.",
        idea = "An instruction, a few examples, and a requested shape change the answer. A typed shape is a contract the app can store.",
        prerequisites = listOf("transformers"),
        runInputs = listOf(
        "One instruction",
        "A field name the answer must contain",
        ),
        passCondition = "The drafted prompt contains the instruction and the field name.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai/prompt/android",
        "https://developers.google.com/ml-kit/genai/prompt/android/structured-output",
        ),
        activityClassName = "com.mabrouk.ailab.prompting.PromptingLabActivity",
    )
}
