package com.mabrouk.ailab.inference

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object InferenceLab {
    val lab = Lab(
        id = "inference",
        title = "Inference and a model card",
        track = Track.Literacy,
        order = 1,
        summary = "Read a model card before you run a model.",
        idea = "A model card states the task, the input, the output, and the size. Inference uses the finished weights.",
        prerequisites = emptyList(),
        runInputs = listOf(
            "A model-card line (task, input, output, or size)",
        ),
        passCondition = "Each line is named with the matching field.",
        sources = listOf(
            "https://developers.google.com/machine-learning/glossary",
        ),
        activityClassName = "com.mabrouk.ailab.inference.InferenceLabActivity",
    )
}
