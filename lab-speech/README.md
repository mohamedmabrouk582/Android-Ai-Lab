# Speech in and speech out

## What this topic is

Speech in turns audio into text. Speech out turns text into audio.

## Why an Android AI engineer needs it

A lab the learner can talk to still ends as text the model can read.

## Diagram

```mermaid
flowchart LR
  n0["Microphone"] --> n1["Text"] --> n2["Speaker"]
```

## What you will change

- A phrase

## Pass condition

The recognized text is shown and the same phrase is the one sent to speech output.

## Sources

- [SpeechRecognizer](https://developer.android.com/reference/android/speech/SpeechRecognizer)
- [TextToSpeech](https://developer.android.com/reference/android/speech/tts/TextToSpeech)
- [ML Kit GenAI overview](https://developers.google.com/ml-kit/genai)
