package com.mabrouk.ailab.appfunctions

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object AppfunctionsLab {
    val lab = Lab(
        id = "appfunctions",
        title = "AppFunctions",
        track = Track.Android,
        order = 26,
        summary = "A tool the phone can call has a declaration and a KDoc.",
        idea = "The app publishes a function the system can offer to an agent. The agent calls it without opening the UI.",
        prerequisites = listOf("performance"),
        runInputs = listOf(
        "A function name",
        "One argument",
        ),
        passCondition = "The declared function returns the value for that argument.",
        sources = listOf(
        "https://developer.android.com/ai/appfunctions",
        "https://developer.android.com/ai/appfunctions/add-appfunctions",
        ),
        activityClassName = "com.mabrouk.ailab.appfunctions.AppfunctionsLabActivity",
    )
}
