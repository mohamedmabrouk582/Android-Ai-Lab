package com.mabrouk.ailab.playpolicy

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object PlayPolicyLab {
    val lab = Lab(
        id = "play-policy",
        title = "Play policy for AI features",
        track = Track.Android,
        order = 28,
        summary = "A generative feature has a policy checklist.",
        idea = "Generative features need a block on restricted content, a way to report output, and testing against hostile prompts.",
        prerequisites = listOf("testing"),
        runInputs = listOf(
        "A feature description",
        ),
        passCondition = "The checklist items the feature still lacks are listed, and an empty list is the pass.",
        sources = listOf(
        "https://support.google.com/googleplay/android-developer/answer/14094294",
        ),
        activityClassName = "com.mabrouk.ailab.playpolicy.PlayPolicyLabActivity",
    )
}
