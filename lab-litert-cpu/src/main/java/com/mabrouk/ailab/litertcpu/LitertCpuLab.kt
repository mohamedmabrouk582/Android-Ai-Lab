package com.mabrouk.ailab.litertcpu

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object LitertCpuLab {
    val lab = Lab(
        id = "litert-cpu",
        title = "LiteRT on CPU",
        track = Track.Android,
        order = 17,
        summary = "Run your own model on the CPU.",
        idea = "CompiledModel runs a .tflite file. Input and output TensorBuffers are allocated once and reused. The deprecated Interpreter API is not used.",
        prerequisites = listOf("genai-tasks"),
        runInputs = listOf(
        "A model file name",
        "An input shape",
        ),
        passCondition = "One inference returns a buffer whose length matches the output shape.",
        sources = listOf(
        "https://ai.google.dev/edge/litert/android",
        "https://developers.google.com/edge/litert/android/compiled_model_java",
        ),
        activityClassName = "com.mabrouk.ailab.litertcpu.LitertCpuLabActivity",
    )
}
