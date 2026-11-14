package com.mabrouk.ailab.outputs

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object OutputsLab {
    val lab = Lab(
        id = "outputs",
        title = "Reading a model output",
        track = Track.Literacy,
        order = 5,
        summary = "Interpret scores and boxes before you show them.",
        idea = "Classifiers return scores, detectors return boxes and labels, and a raw buffer is neither a decision.",
        prerequisites = listOf("embeddings"),
        runInputs = listOf(
        "A score list",
        ),
        passCondition = "The top label is the highest score, and scores below a stated threshold are dropped.",
        sources = listOf(
        "https://developers.google.com/machine-learning/glossary",
        "https://developers.google.com/ml-kit/vision",
        ),
        activityClassName = "com.mabrouk.ailab.outputs.OutputsLabActivity",
    )
}
