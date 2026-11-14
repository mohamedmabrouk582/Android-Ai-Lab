package com.mabrouk.ailab.ondevicerag

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object OnDeviceRagLab {
    val lab = Lab(
        id = "on-device-rag",
        title = "On-device embeddings and RAG",
        track = Track.Android,
        order = 21,
        summary = "RAG from topic 8, with the vectors kept on the device.",
        idea = "Embed notes on the phone, store the vectors in a small index, and answer from the retrieved note.",
        prerequisites = listOf("model-delivery", "embeddings", "rag"),
        runInputs = listOf(
        "Notes typed in the lab",
        "One question",
        ),
        passCondition = "The answer quotes a note that was stored in the index.",
        sources = listOf(
        "https://developers.google.com/machine-learning/crash-course/embeddings/video-lecture",
        "https://cloud.google.com/vertex-ai/generative-ai/docs/rag-overview",
        ),
        activityClassName = "com.mabrouk.ailab.ondevicerag.OnDeviceRagLabActivity",
    )
}
