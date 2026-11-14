package com.mabrouk.ailab.privacy

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object PrivacyLab {
    val lab = Lab(
        id = "privacy",
        title = "Privacy, safety, on-device and cloud",
        track = Track.Literacy,
        order = 12,
        summary = "Pick where the bytes go before you pick a model.",
        idea = "On-device keeps the input on the phone. Cloud sends it away. A hybrid path sends only what the on-device model cannot do.",
        prerequisites = listOf("quantization"),
        runInputs = listOf(
        "A feature description",
        ),
        passCondition = "The lab's label is on-device, cloud, or hybrid and matches the rule on screen.",
        sources = listOf(
        "https://developers.google.com/ml-kit/genai",
        "https://developer.android.com/ai/appfunctions",
        ),
        activityClassName = "com.mabrouk.ailab.privacy.PrivacyLabActivity",
    )
}
