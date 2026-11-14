package com.mabrouk.ailab.rag

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object RagLab {
    val lab = Lab(
        id = "rag",
        title = "RAG",
        track = Track.Literacy,
        order = 8,
        summary = "The answer has to point at retrieved text.",
        idea = "Split notes into chunks, embed the chunks, retrieve the closest ones, and answer from those chunks.",
        prerequisites = listOf("prompting", "embeddings"),
        runInputs = listOf(
        "Note 1",
        "Note 2",
        "Note 3",
        "Question",
        ),
        passCondition = "The retrieved note is the one that shares the question's terms, and the answer quotes it.",
        sources = listOf(
        "https://cloud.google.com/vertex-ai/generative-ai/docs/rag-overview",
        ),
        activityClassName = "com.mabrouk.ailab.rag.RagLabActivity",
    )
}
