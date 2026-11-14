package com.mabrouk.ailab.lab

enum class Track {
    Literacy,
    Android,
}

data class Lab(
    val id: String,
    val title: String,
    val track: Track,
    val order: Int,
    val summary: String,
    val idea: String,
    val prerequisites: List<String>,
    val runInputs: List<String>,
    val passCondition: String,
    val sources: List<String>,
    val activityClassName: String,
)
