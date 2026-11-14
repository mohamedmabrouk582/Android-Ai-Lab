package com.mabrouk.ailab.tokens

import com.mabrouk.ailab.lab.Lab
import com.mabrouk.ailab.lab.Track

object TokensLab {
    val lab = Lab(
        id = "tokens",
        title = "Tokens",
        track = Track.Literacy,
        order = 3,
        summary = "Text becomes token ids before a prompt is sent.",
        idea = "A language model reads token ids, not raw characters. The same sentence can produce a different count under a different tokenizer.",
        prerequisites = listOf("tensors"),
        runInputs = listOf(
        "One sentence",
        ),
        passCondition = "The shown token count equals the splitter used by the lab.",
        sources = listOf(
        "https://developers.google.com/machine-learning/glossary",
        "https://developers.google.com/ml-kit/genai/prompt/android",
        ),
        activityClassName = "com.mabrouk.ailab.tokens.TokensLabActivity",
    )
}
