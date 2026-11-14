package com.mabrouk.ailab.embeddings

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object EmbeddingsLab {
    val lab = Lab(
        id = "embeddings",
        title = "Embeddings and similarity",
        track = Track.Literacy,
        order = 4,
        summary = "Similar items land near each other in vector space.",
        idea = "An embedding is a vector for a piece of text or an image. Cosine similarity ranks which pieces are close.",
        prerequisites = listOf("tokens"),
        runInputs = listOf(
        "First phrase",
        "Second phrase",
        ),
        passCondition = "The higher cosine pair is the pair the lab marks as closer.",
        sources = listOf(
        "https://developers.google.com/machine-learning/crash-course/embeddings/video-lecture",
        ),
        activityClassName = "com.mabrouk.ailab.embeddings.EmbeddingsLabActivity",
    )
}
