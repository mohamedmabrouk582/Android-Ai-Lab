package com.mabrouk.ailab.litertlm

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object LitertLmLab {
    val lab = Lab(
        id = "litert-lm",
        title = "LiteRT LM",
        track = Track.Android,
        order = 22,
        summary = "Run an open language model you ship yourself.",
        idea = "An open .litertlm model runs through LiteRT-LM, which is a different stack from Gemini Nano.",
        prerequisites = listOf("on-device-rag"),
        runInputs = listOf(
        "A prompt",
        ),
        passCondition = "The screen shows generated text, or an explanation when the model file is absent, and absence does not mark the lab passed.",
        sources = listOf(
        "https://developers.google.com/edge/litert-lm/android",
        ),
        activityClassName = "com.mabrouk.ailab.litertlm.LitertLmLabActivity",
    )
}
