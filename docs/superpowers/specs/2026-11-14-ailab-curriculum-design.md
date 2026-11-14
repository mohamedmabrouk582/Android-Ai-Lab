# Ai Lab curriculum design

Ai Lab is a course app for an Android engineer becoming an Android AI engineer. One installed app holds 28 topic labs. Each topic is a Gradle library module with its own screen, its own learning note, and a Studio run configuration that opens that screen.

Recall and Kotlin Multiplatform are out of this project. This slice scaffolds every topic. It does not run models.

## Decisions

- Practitioner course. Track 1 is shared AI literacy. Track 2 is Android, and those topics stay deeper when their benches are built.
- Any topic opens. Order is the suggested path. The home screen highlights the next unfinished topic. Prerequisites are shown and do not lock the topic.
- One application module, `:app`. One Android library per topic. A shared `:lab-api` library holds the contract, the theme, the progress store, and the registry.
- Each topic owns one Activity. The Activity is the test bench: Idea, Run, and Check. Home starts it. A shared Studio run configuration starts that same Activity.
- `minSdk` is 26 on `:app` and every library. `compileSdk` and `targetSdk` stay 37. The Prompt API requires 26, and one app covers every lab.
- This slice creates all 28 modules now. Run and Check are visible and inactive. No ML Kit, LiteRT, CameraX, or AppFunctions dependency is added until that topic’s bench is built.
- A passed check will write the lab id into a shared preferences file. Nothing in this slice calls that write.
- Official pages stay the specification. Each learning note explains the topic in our words, shows one diagram, and links the pages it is based on.

## Modules

`:lab-api` (`com.mabrouk.ailab.lab`)

- `Lab` data: `id`, `title`, `track` (`Literacy` or `Android`), `order` (1–28), `summary`, `idea`, `prerequisites` (lab ids), `runInputs`, `passCondition`, `sources` (absolute https URLs), `activityClassName` (fully qualified Activity class).
- `LabRegistry.register` throws `IllegalStateException` if the id or the order is already registered. `labs()` returns labs sorted by `order`. `clearForTest()` exists so unit tests can reset it.
- `LabProgress` uses the private preferences file `ailab_progress` and the string-set key `passed_ids`. `passedIds()` returns the set. `markPassed(id)` adds one id. Both use the application context.
- `AiLabTheme` and the existing color and type files move from `:app` into `:lab-api`. `:app` uses that theme.

`:app` (`com.mabrouk.ailab`)

- The only `com.android.application` module. It depends on `:lab-api` and all 28 lab modules.
- `Application.onCreate` requires `LabRegistry.labs()` to contain 28 labs, orders `1..28`, and unique ids. A missing module crashes startup on purpose.
- Home is a `LazyColumn` titled “Ai Lab”. Literacy labs sit under “Track 1. AI literacy”. Android labs sit under “Track 2. Android labs”.
- A row shows the order, the title, and the summary. The lowest order whose id is absent from `passedIds()` also shows “Next”. An id present in `passedIds()` shows “Done”.
- Tapping a row starts `Class.forName(activityClassName)` as an Activity. If that class is missing, the row stays and the screen shows “This lab is not installed.”

Each `:lab-<name>` module

- Android library. Depends on `:lab-api`, the Compose BOM, Material 3, activity-compose, and `startup-runtime`. Compose is enabled. No topic SDK yet.
- Namespace `com.mabrouk.ailab.<id>` with hyphens removed from the package segment (`on-device-rag` becomes `com.mabrouk.ailab.ondevicerag`). The lab `id` keeps its hyphen.
- The lab id `on-device-rag` becomes the type name `OnDeviceRag`. The Kotlin object is `<Type>Lab` and the Activity is `<Type>LabActivity`. Inference is `InferenceLab` and `InferenceLabActivity`.
- The Kotlin object holds the `Lab` data and does not import Android UI types.
- The Activity applies `AiLabTheme` and shows `LabScreen`. Its class name is stored in `activityClassName`.
- An `androidx.startup` `Initializer` registers that `Lab`. The library manifest merges the initializer into `InitializationProvider`. The Activity is `exported="false"`.
- `LabScreen` lives in `:lab-api` so every topic looks the same. It shows the title, the track, the order, “Suggested after” when prerequisites are non-empty, then three sections:
  - Idea: the `idea` text.
  - Run: one disabled text field per `runInputs` entry, and a disabled Run button.
  - Check: the `passCondition`, and a disabled Check button.
  - One line under the buttons: “The interactive bench for this topic is not built yet.”

Version catalog

- Add the Android library plugin alias next to the existing application plugin.
- Add `androidx.startup:startup-runtime` version `1.2.0`.

Studio

- Commit one run configuration per lab under `.run/`.
- Type `AndroidRunConfigurationType`, mode `specific_activity`, activity set to that lab’s class name.
- The module attribute is `Ai_Lab.app` in every file. The root project name is `Ai Lab`, which Android Studio imports as `Ai_Lab`.

## Learning notes

Root `README.md`

- Preface: Ai Lab is the course from Android engineer to Android AI engineer. One app, one module per topic, open any topic, finish a topic by passing its check once the bench exists.
- How to run: open the app for the course map, or run a topic’s Studio configuration.
- A table of all 28 modules. Each row links to that module’s `README.md`.
- A short statement that Run and Check are scaffolded and the benches come next.

Each module `README.md`

- What this topic is.
- Why an Android AI engineer needs it.
- One Mermaid flowchart of the pipeline described below.
- What the lab will let you change, matching `runInputs`.
- The pass condition, matching `passCondition`.
- Sources, the same URLs as `sources`.

## Catalog

`prerequisites` for topic 1 is empty. For every later topic it contains the previous topic’s id. A row’s extra ids are added as well. The lab screen labels that list “Suggested after”.

1. `:lab-inference` `inference` — Inference and a model card. A model card states the task, the input, the output, and the size. Inference uses the finished weights. Summary: Read a model card before you run a model. Run input: a model-card line (task, input, output, or size). Pass: each line is named with the matching field. Diagram: model card fields point at one inference call. Sources: [Machine Learning Glossary](https://developers.google.com/machine-learning/glossary). Extra prerequisites: none.

2. `:lab-tensors` `tensors` — Tensors, shapes, and preprocessing. A tensor is an array with a shape and a dtype. A vision model also needs a known scale and channel order before the first inference. Summary: Shape and dtype decide whether an input fits a model. Run input: a shape such as `1x224x224x3` and a dtype name. Pass: the shape’s rank and element count match the text. Diagram: raw image to scale and layout to tensor. Sources: [Machine Learning Glossary](https://developers.google.com/machine-learning/glossary), [LiteRT on Android](https://ai.google.dev/edge/litert/android).

3. `:lab-tokens` `tokens` — Tokens. A language model reads token ids, not raw characters. The same sentence can produce a different count under a different tokenizer. Summary: Text becomes token ids before a prompt is sent. Run input: one sentence. Pass: the shown token count equals the splitter used by the lab. Diagram: sentence to pieces to ids. Sources: [Machine Learning Glossary](https://developers.google.com/machine-learning/glossary), [Prompt API](https://developers.google.com/ml-kit/genai/prompt/android).

4. `:lab-embeddings` `embeddings` — Embeddings and similarity. An embedding is a vector for a piece of text or an image. Cosine similarity ranks which pieces are close. Summary: Similar items land near each other in vector space. Run input: two short phrases. Pass: the higher cosine pair is the pair the lab marks as closer. Diagram: two phrases to two vectors to one similarity score. Sources: [Embeddings crash course](https://developers.google.com/machine-learning/crash-course/embeddings/video-lecture).

5. `:lab-outputs` `outputs` — Reading a model output. Classifiers return scores, detectors return boxes and labels, and a raw buffer is neither a decision. Summary: Interpret scores and boxes before you show them. Run input: a score list. Pass: the top label is the highest score, and scores below a stated threshold are dropped. Diagram: output tensor to scores to kept labels. Sources: [Machine Learning Glossary](https://developers.google.com/machine-learning/glossary), [ML Kit vision](https://developers.google.com/ml-kit/vision).

6. `:lab-transformers` `transformers` — Transformers, intuition. Attention lets each token look at the others in the context window. This lab does not train a transformer. Summary: The context window is the text the model can see at once. Run input: a short prompt plus a window size in tokens. Pass: the lab marks the prompt as fitting or overflowing that window. Diagram: tokens into a window into attention. Sources: [Machine Learning Glossary](https://developers.google.com/machine-learning/glossary).

7. `:lab-prompting` `prompting` — Prompting and structured output. An instruction, a few examples, and a requested shape change the answer. A typed shape is a contract the app can store. Summary: Ask for a shape, not only a paragraph. Run input: one instruction and a field name the answer must contain. Pass: the drafted prompt contains the instruction and the field name. Diagram: instruction and example to prompt to typed fields. Sources: [Prompt API](https://developers.google.com/ml-kit/genai/prompt/android), [Structured output](https://developers.google.com/ml-kit/genai/prompt/android/structured-output).

8. `:lab-rag` `rag` — RAG. Split notes into chunks, embed the chunks, retrieve the closest ones, and answer from those chunks. Summary: The answer has to point at retrieved text. Run input: three notes and one question. Pass: the retrieved note is the one that shares the question’s terms, and the answer quotes it. Diagram: notes to chunks to vectors to retrieved note to answer. Sources: [Retrieval-augmented generation](https://cloud.google.com/vertex-ai/generative-ai/docs/rag-overview). Extra prerequisites: `embeddings`.

9. `:lab-agents` `agents` — Tools and a small agent loop. The model chooses a tool, the app runs it, and the tool result goes back into the next turn. Summary: The app runs the tool. The model only requests it. Run input: a question that needs one arithmetic tool. Pass: the loop calls the tool once and the final text contains the tool result. Diagram: question to tool request to app result to final text. Sources: [ML Kit GenAI overview](https://developers.google.com/ml-kit/genai).

10. `:lab-evaluation` `evaluation` — Evaluation. A golden set of questions with known answers shows whether a change helped. Track retrieval hits and wrong answers separately. Summary: Keep a golden set before you trust a prompt. Run input: three expected answers and three actual answers. Pass: the score equals the number of exact matches. Diagram: golden pair to match or miss to a score. Sources: [ML Kit GenAI overview](https://developers.google.com/ml-kit/genai).

11. `:lab-quantization` `quantization` — Quantization, latency, memory, and battery. Lower precision makes a model smaller and usually faster, and it can change answers. Summary: Size, latency, and answer quality move together. Run input: a size in megabytes and a bit width (32, 8, or 4). Pass: the estimated smaller size follows the bit-width ratio the screen states. Diagram: float model to int8 or int4 to a smaller file and a latency bar. Sources: [LiteRT on Android](https://ai.google.dev/edge/litert/android).

12. `:lab-privacy` `privacy` — Privacy, safety, on-device and cloud. On-device keeps the input on the phone. Cloud sends it away. A hybrid path sends only what the on-device model cannot do. Summary: Pick where the bytes go before you pick a model. Run input: a feature description. Pass: the lab’s label is on-device, cloud, or hybrid and matches the rule on screen. Diagram: user text to a three-way choice of device, cloud, or hybrid. Sources: [ML Kit GenAI overview](https://developers.google.com/ml-kit/genai), [AppFunctions overview](https://developer.android.com/ai/appfunctions).

13. `:lab-mlkit-tasks` `mlkit-tasks` — ML Kit task APIs. Text recognition, barcode, face, and pose are ready-made models with a task API. Summary: Call a task API before you ship a custom model. Run input: a task name. Pass: the screen lists what that task returns (text, a code, faces, or landmarks). Diagram: image to a task API to a typed result. Sources: [ML Kit vision](https://developers.google.com/ml-kit/vision).

14. `:lab-prompt-api` `prompt-api` — Gemini Nano Prompt API. Check `FeatureStatus`, download when the model is downloadable, stream or wait, and `close()` the client. The model is unavailable on some phones, including unlocked bootloaders. Summary: Ask Gemini Nano only after the feature is available. Run input: one prompt. Pass: the status is shown, and a missing model stays on an explanation screen without a passed check. Diagram: status check to download or generate to a closed client. Sources: [Get started with the Prompt API](https://developers.google.com/ml-kit/genai/prompt/android/get-started), [Prompt API overview](https://developers.google.com/ml-kit/genai/prompt/android).

15. `:lab-structured-output` `structured-output` — Structured output and prefix caching. A Kotlin type is the response contract. A repeated prefix can be cached apart from the changing suffix. Summary: Parse a typed object, and cache the stable prefix. Run input: a prefix and a suffix. Pass: the screen shows a typed object, and the prefix is marked as the cached part. Diagram: prefix cache plus suffix to a typed object. Sources: [Structured output](https://developers.google.com/ml-kit/genai/prompt/android/structured-output), [Prefix caching](https://developer.android.com/agents/skills/device-ai/ml-kit-genai-prompt-api/references/prefix-caching).

16. `:lab-genai-tasks` `genai-tasks` — Summarize, rewrite, proofread, and describe an image. These GenAI tasks are fixed jobs on Gemini Nano, separate from a free-form prompt. Summary: Use a task API when the job already has a name. Run input: a task name and a paragraph or image description. Pass: the named task is the one that runs, and the result is text. Diagram: text or image to a named GenAI task to text. Sources: [ML Kit GenAI overview](https://developers.google.com/ml-kit/genai).

17. `:lab-litert-cpu` `litert-cpu` — LiteRT on CPU. `CompiledModel` runs a `.tflite` file. Input and output `TensorBuffer`s are allocated once and reused. The deprecated `Interpreter` API is not used. Summary: Run your own model on the CPU. Run input: a model file name and an input shape. Pass: one inference returns a buffer whose length matches the output shape. Diagram: asset file to CompiledModel to reused buffers to an output. Sources: [LiteRT on Android](https://ai.google.dev/edge/litert/android), [CompiledModel in Play services](https://developers.google.com/edge/litert/android/compiled_model_java).

18. `:lab-litert-gpu` `litert-gpu` — GPU, one thread, warm-up, and latency. One background thread owns the model. GPU options list CPU as the fallback. Measure `run` together with the output read. Warm up once so the first user tap is not the shader compile. Summary: Time the steady run, and keep the model on one thread. Run input: a repeat count. Pass: the screen shows a warm-up time and a steady-run time. Diagram: create on one thread, warm up, then timed runs. Sources: [LiteRT on Android](https://ai.google.dev/edge/litert/android).

19. `:lab-litert-runtime` `litert-runtime` — Play services LiteRT and the bundled runtime. Play services keeps the runtime out of the APK. The bundled runtime is for NPU, custom ops, or devices without Play services. One build variant contains one of them. Summary: Pick one runtime and know why. Run input: a runtime name. Pass: the screen states which artifact that choice adds and which case forbids mixing them. Diagram: choice of Play services or bundled AAR to one variant. Sources: [CompiledModel in Play services](https://developers.google.com/edge/litert/android/compiled_model_java), [LiteRT on Android](https://ai.google.dev/edge/litert/android). Extra prerequisites: `litert-cpu`.

20. `:lab-model-delivery` `model-delivery` — Assets, AI packs, and downloads. Small models ship in assets. Larger ones ship as a Play AI pack or a file in app storage. An on-demand pack is null until it has downloaded. Summary: The model file has an address, and the app has to wait for it. Run input: a delivery mode (assets, install-time pack, on-demand pack, or download). Pass: the screen names where `CompiledModel.create` reads for that mode. Diagram: three delivery paths into one create call. Sources: [Play for On-device AI](https://developer.android.com/google/play/on-device-ai). Extra prerequisites: `litert-cpu`.

21. `:lab-on-device-rag` `on-device-rag` — On-device embeddings and RAG. Embed notes on the phone, store the vectors in a small index, and answer from the retrieved note. Summary: RAG from topic 8, with the vectors kept on the device. Run input: notes typed in the lab and one question. Pass: the answer quotes a note that was stored in the index. Diagram: typed notes to on-device vectors to an index to an answer. Sources: [Embeddings crash course](https://developers.google.com/machine-learning/crash-course/embeddings/video-lecture), [Retrieval-augmented generation](https://cloud.google.com/vertex-ai/generative-ai/docs/rag-overview). Extra prerequisites: `embeddings`, `rag`.

22. `:lab-litert-lm` `litert-lm` — LiteRT LM. An open `.litertlm` model runs through LiteRT-LM, which is a different stack from Gemini Nano. Summary: Run an open language model you ship yourself. Run input: a prompt. Pass: the screen shows generated text, or an explanation when the model file is absent, and absence does not mark the lab passed. Diagram: `.litertlm` file to LiteRT-LM to text. Sources: [LiteRT-LM on Android](https://developers.google.com/edge/litert-lm/android).

23. `:lab-speech` `speech` — Speech in and speech out. Speech in turns audio into text. Speech out turns text into audio. Summary: The prompt can start as speech and the answer can be spoken. Run input: a phrase. Pass: the recognized text is shown and the same phrase is the one sent to speech output. Diagram: microphone to text to speaker. Sources: [SpeechRecognizer](https://developer.android.com/reference/android/speech/SpeechRecognizer), [TextToSpeech](https://developer.android.com/reference/android/speech/tts/TextToSpeech), [ML Kit GenAI overview](https://developers.google.com/ml-kit/genai).

24. `:lab-camerax` `camerax` — CameraX into a vision model. Frames are analyzed on a background executor, converted to the model’s tensor layout, and the latest result is what the UI shows. Summary: A live camera is a stream of tensors. Run input: the camera preview. Pass: the screen shows a label for the current frame and drops work when a frame is still running. Diagram: preview to analyzer to tensor to a label. Sources: [CameraX](https://developer.android.com/media/camera/camerax), [ML Kit vision](https://developers.google.com/ml-kit/vision). Extra prerequisites: `tensors`, `mlkit-tasks`.

25. `:lab-performance` `performance` — First run, heat, and the profiler. The first inference includes compile and load. Later inferences show the steady cost. Summary: Record first-run and steady-run separately. Run input: a repeat count. Pass: the screen shows both times and names the profiler trace to capture. Diagram: cold start to warm-up to steady samples. Sources: [LiteRT on Android](https://ai.google.dev/edge/litert/android), [Android Studio profiler](https://developer.android.com/studio/profile). Extra prerequisites: `litert-gpu`.

26. `:lab-appfunctions` `appfunctions` — AppFunctions. The app publishes a function the system can offer to an agent. The agent calls it without opening the UI. Summary: A tool the phone can call has a declaration and a KDoc. Run input: a function name and one argument. Pass: the declared function returns the value for that argument. Diagram: declaration to system index to an agent call to a result. Sources: [AppFunctions overview](https://developer.android.com/ai/appfunctions), [Add AppFunctions](https://developer.android.com/ai/appfunctions/add-appfunctions).

27. `:lab-testing` `testing` — Testing a missing or known model. Tests cover feature unavailable, still downloading, and a golden output. Summary: The lab has a result when the model is missing. Run input: a status (unavailable, downloading, or ready) and a golden output. Pass: unavailable and downloading fail the check with an explanation, and ready passes only when the output matches the golden value. Diagram: status branch to explanation or to a golden compare. Sources: [Android app testing](https://developer.android.com/training/testing). Extra prerequisites: `prompt-api`, `litert-cpu`.

28. `:lab-play-policy` `play-policy` — Play policy for AI features. Generative features need a block on restricted content, a way to report output, and testing against hostile prompts. Summary: A generative feature has a policy checklist. Run input: a feature description. Pass: the checklist items the feature still lacks are listed, and an empty list is the pass. Diagram: feature to the policy checklist to pass or missing items. Sources: [AI-Generated Content policy](https://support.google.com/googleplay/android-developer/answer/14094294).

## Error handling

- Duplicate lab id or order throws when the process starts.
- A missing Activity class shows “This lab is not installed.” and does not crash the home screen.
- Inactive Run and Check do not write progress and do not throw.
- When a bench is built later, a model that is missing, downloading, or unsupported opens an explanation and does not call `markPassed`.

## Testing

- `:lab-api` JVM test: registering two labs sorts by order; a repeated id throws; a repeated order throws; `clearForTest()` allows a new registration.
- `:app` JVM test: construct the 28 `Lab` objects, assert unique ids, orders `1..28`, non-blank idea, at least one run input, non-blank pass condition, and at least one https source. This test references the lab objects, not the Activities.
- `Application.onCreate` performs the same 28-lab check against `LabRegistry` after startup initializers have run.
- This slice has no instrumented UI test and no device run requirement.

## Git

The GitHub repo `https://github.com/mohamedmabrouk582/Android-Ai-Lab` already has `LICENSE` on `main` and no app. Implementation initializes git in this project, adds that URL as `origin`, brings `LICENSE` onto the local branch without a force push, commits the scaffold, and pushes to `main`. `local.properties` stays untracked.

## Out of scope

- Live Run and Check behavior, model files, and topic SDK dependencies.
- Play Feature Delivery modules and one installable app per topic.
- Recall, Kotlin Multiplatform, and iOS.
- Training, fine-tuning, and MLOps.
