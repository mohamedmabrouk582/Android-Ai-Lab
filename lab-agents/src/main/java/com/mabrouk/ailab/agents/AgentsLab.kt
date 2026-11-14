package com.mabrouk.ailab.agents

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object AgentsLab {
    val lab = Lab(
        id = "agents",
        title = "Tools and a small agent loop",
        track = Track.Literacy,
        order = 9,
        summary = "The app runs the tool. The model only requests it.",
        idea = "The model chooses a tool, the app runs it, and the tool result goes back into the next turn.",
        prerequisites = listOf("rag"),
        runInputs = listOf(
        "A question that needs one arithmetic tool",
        ),
        passCondition = "The loop calls the tool once and the final text contains the tool result.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai",
        ),
        activityClassName = "com.mabrouk.ailab.agents.AgentsLabActivity",
    )
}
