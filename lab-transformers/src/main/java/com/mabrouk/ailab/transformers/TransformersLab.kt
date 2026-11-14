package com.mabrouk.ailab.transformers

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object TransformersLab {
    val lab = Lab(
        id = "transformers",
        title = "Transformers, intuition",
        track = Track.Literacy,
        order = 6,
        summary = "The context window is the text the model can see at once.",
        idea = "Attention lets each token look at the others in the context window. This lab does not train a transformer.",
        prerequisites = listOf("outputs"),
        runInputs = listOf(
        "A short prompt",
        "A window size in tokens",
        ),
        passCondition = "The lab marks the prompt as fitting or overflowing that window.",
        sources = listOf(
        "https://developers.google.com/machine-learning/glossary",
        ),
        activityClassName = "com.mabrouk.ailab.transformers.TransformersLabActivity",
    )
}
