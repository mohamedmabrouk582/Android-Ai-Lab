package com.mabrouk.ailab.modeldelivery

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object ModelDeliveryLab {
    val lab = Lab(
        id = "model-delivery",
        title = "Assets, AI packs, and downloads",
        track = Track.Android,
        order = 20,
        summary = "The model file has an address, and the app has to wait for it.",
        idea = "Small models ship in assets. Larger ones ship as a Play AI pack or a file in app storage. An on-demand pack is null until it has downloaded.",
        prerequisites = listOf("litert-runtime", "litert-cpu"),
        runInputs = listOf(
        "A delivery mode (assets, install-time pack, on-demand pack, or download)",
        ),
        passCondition = "The screen names where CompiledModel.create reads for that mode.",
        sources = listOf(
        "https://developer.android.com/google/play/on-device-ai",
        ),
        activityClassName = "com.mabrouk.ailab.modeldelivery.ModelDeliveryLabActivity",
    )
}
