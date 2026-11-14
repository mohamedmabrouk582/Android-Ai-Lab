package com.mabrouk.ailab.tensors

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object TensorsLab {
    val lab = Lab(
        id = "tensors",
        title = "Tensors, shapes, and preprocessing",
        track = Track.Literacy,
        order = 2,
        summary = "Shape and dtype decide whether an input fits a model.",
        idea = "A tensor is an array with a shape and a dtype. A vision model also needs a known scale and channel order before the first inference.",
        prerequisites = listOf("inference"),
        runInputs = listOf(
            "A shape such as 1x224x224x3",
            "A dtype name",
        ),
        passCondition = "The shape's rank and element count match the text.",
        sources = listOf(
            "https://developers.google.com/machine-learning/glossary",
            "https://ai.google.dev/edge/litert/android",
        ),
        activityClassName = "com.mabrouk.ailab.tensors.TensorsLabActivity",
    )
}
