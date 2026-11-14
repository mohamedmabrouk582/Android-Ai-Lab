package com.mabrouk.ailab.genaitasks

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object GenaiTasksLab {
    val lab = Lab(
        id = "genai-tasks",
        title = "Summarize, rewrite, proofread, and describe an image",
        track = Track.Android,
        order = 16,
        summary = "Use a task API when the job already has a name.",
        idea = "These GenAI tasks are fixed jobs on Gemini Nano, separate from a free-form prompt.",
        prerequisites = listOf("structured-output"),
        runInputs = listOf(
        "A task name",
        "A paragraph or image description",
        ),
        passCondition = "The named task is the one that runs, and the result is text.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai",
        ),
        activityClassName = "com.mabrouk.ailab.genaitasks.GenaiTasksLabActivity",
    )
}
