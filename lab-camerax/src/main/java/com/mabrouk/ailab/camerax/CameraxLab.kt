package com.mabrouk.ailab.camerax

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object CameraxLab {
    val lab = Lab(
        id = "camerax",
        title = "CameraX into a vision model",
        track = Track.Android,
        order = 24,
        summary = "A live camera is a stream of tensors.",
        idea = "Frames are analyzed on a background executor, converted to the model's tensor layout, and the latest result is what the UI shows.",
        prerequisites = listOf("speech", "tensors", "mlkit-tasks"),
        runInputs = listOf(
        "The camera preview",
        ),
        passCondition = "The screen shows a label for the current frame and drops work when a frame is still running.",
        sources = listOf(
        "https://developer.android.com/media/camera/camerax",
        "https://developers.google.com/ml-kit/vision",
        ),
        activityClassName = "com.mabrouk.ailab.camerax.CameraxLabActivity",
    )
}
