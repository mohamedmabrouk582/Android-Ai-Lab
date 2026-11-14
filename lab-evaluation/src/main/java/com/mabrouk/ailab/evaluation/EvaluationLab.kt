package com.mabrouk.ailab.evaluation

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object EvaluationLab {
    val lab = Lab(
        id = "evaluation",
        title = "Evaluation",
        track = Track.Literacy,
        order = 10,
        summary = "Keep a golden set before you trust a prompt.",
        idea = "A golden set of questions with known answers shows whether a change helped. Track retrieval hits and wrong answers separately.",
        prerequisites = listOf("agents"),
        runInputs = listOf(
        "Expected answer 1",
        "Expected answer 2",
        "Expected answer 3",
        "Actual answer 1",
        "Actual answer 2",
        "Actual answer 3",
        ),
        passCondition = "The score equals the number of exact matches.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai",
        ),
        activityClassName = "com.mabrouk.ailab.evaluation.EvaluationLabActivity",
    )
}
