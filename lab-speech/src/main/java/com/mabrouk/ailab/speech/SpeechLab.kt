package com.mabrouk.ailab.speech

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object SpeechLab {
    val lab = Lab(
        id = "speech",
        title = "Speech in and speech out",
        track = Track.Android,
        order = 23,
        summary = "The prompt can start as speech and the answer can be spoken.",
        idea = "Speech in turns audio into text. Speech out turns text into audio.",
        prerequisites = listOf("litert-lm"),
        runInputs = listOf(
        "A phrase",
        ),
        passCondition = "The recognized text is shown and the same phrase is the one sent to speech output.",
        sources = listOf(
        "https://developer.android.com/reference/android/speech/SpeechRecognizer",
        "https://developer.android.com/reference/android/speech/tts/TextToSpeech",
        "https://developers.google.com/ml-kit/genai",
        ),
        activityClassName = "com.mabrouk.ailab.speech.SpeechLabActivity",
    )
}
