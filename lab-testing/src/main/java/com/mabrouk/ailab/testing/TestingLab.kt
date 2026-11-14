package com.mabrouk.ailab.testing

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object TestingLab {
    val lab = Lab(
        id = "testing",
        title = "Testing a missing or known model",
        track = Track.Android,
        order = 27,
        summary = "The lab has a result when the model is missing.",
        idea = "Tests cover feature unavailable, still downloading, and a golden output.",
        prerequisites = listOf("appfunctions", "prompt-api", "litert-cpu"),
        runInputs = listOf(
        "A status (unavailable, downloading, or ready)",
        "A golden output",
        ),
        passCondition = "Unavailable and downloading fail the check with an explanation, and ready passes only when the output matches the golden value.",
        sources = listOf(
        "https://developer.android.com/training/testing",
        ),
        activityClassName = "com.mabrouk.ailab.testing.TestingLabActivity",
    )
}
